package me.a8kj.zeta.tokenizer.rules;

import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.token.attributes.TokenCategory;
import me.a8kj.zeta.token.attributes.TokenLocation;
import me.a8kj.zeta.token.impl.LexerToken;
import me.a8kj.zeta.tokenizer.TokenizerRule;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;
import me.a8kj.zeta.tokenizer.regisrty.OperatorRegistry;

import java.util.Optional;

public class OperatorRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        return OperatorRegistry.startsWithOperator(context.getInput(), context.getPosition());
    }

    @Override
    public Token apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        Optional<String> matchedOp = OperatorRegistry.matchOperator(context.getInput(), start);

        if (matchedOp.isEmpty()) {
            throw new RuntimeException("Unknown operator at position: " + start);
        }

        String op = matchedOp.get();
        TokenCategory rawCategory = OperatorRegistry.getCategory(op)
                .orElseThrow(() -> new RuntimeException("No category for operator: " + op));

        if (!(rawCategory instanceof Enum<?>)) {
            throw new RuntimeException("Operator category must be an enum: " + rawCategory);
        }

        @SuppressWarnings("unchecked")
        Enum<? extends TokenCategory> category = (Enum<? extends TokenCategory>) rawCategory;

        for (int i = 0; i < op.length(); i++) {
            context.advance();
        }

        return new LexerToken(op, category, new TokenLocation(column, line, start, context.getPosition()));
    }
}
