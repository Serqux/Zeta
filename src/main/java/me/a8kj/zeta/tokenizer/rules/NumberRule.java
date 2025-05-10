package me.a8kj.zeta.tokenizer.rules;

import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.token.attributes.TokenLocation;
import me.a8kj.zeta.token.categories.LiteralCategory;
import me.a8kj.zeta.token.impl.LexerToken;
import me.a8kj.zeta.tokenizer.TokenizerRule;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;

public class NumberRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        return Character.isDigit(context.currentChar());
    }

    @Override
    public Token apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        while (context.hasNext() && Character.isDigit(context.currentChar())) {
            context.advance();
        }

        String value = context.substring(start, context.getPosition());
        return new LexerToken(value, LiteralCategory.NUMBER,
                new TokenLocation(column, line, start, context.getPosition()));
    }
}
