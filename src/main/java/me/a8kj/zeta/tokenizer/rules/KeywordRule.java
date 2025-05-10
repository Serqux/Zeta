package me.a8kj.zeta.tokenizer.rules;

import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.token.attributes.TokenLocation;
import me.a8kj.zeta.token.categories.keywords.BooleanLiteralKeywordCategory;
import me.a8kj.zeta.token.categories.keywords.ControlKeywordCategory;
import me.a8kj.zeta.token.categories.keywords.DeclarationKeywordCategory;
import me.a8kj.zeta.token.impl.LexerToken;
import me.a8kj.zeta.tokenizer.TokenizerRule;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;

public class KeywordRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        return context.hasNext() && Character.isLetter(context.currentChar());
    }

    @Override
    public Token apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        StringBuilder builder = new StringBuilder();

        while (context.hasNext() && Character.isLetter(context.currentChar())) {
            builder.append(context.currentChar());
            context.advance();
        }

        String value = builder.toString();
        TokenLocation location = new TokenLocation(column, line, start, context.getPosition());

        return matchKeyword(value, location);
    }

    private Token matchKeyword(String value, TokenLocation location) {
        for (DeclarationKeywordCategory keyword : DeclarationKeywordCategory.values()) {
            if (keyword.value().equals(value)) {
                return new LexerToken(value, keyword, location);
            }
        }

        for (ControlKeywordCategory keyword : ControlKeywordCategory.values()) {
            if (keyword.value().equals(value)) {
                return new LexerToken(value, keyword, location);
            }
        }

        for (BooleanLiteralKeywordCategory keyword : BooleanLiteralKeywordCategory.values()) {
            if (keyword.value().equals(value)) {
                return new LexerToken(value, keyword, location);
            }
        }

        return null;
    }
}
