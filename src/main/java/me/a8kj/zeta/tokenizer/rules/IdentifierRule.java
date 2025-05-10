package me.a8kj.zeta.tokenizer.rules;

import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.token.attributes.TokenLocation;
import me.a8kj.zeta.token.categories.IdentifierCategory;
import me.a8kj.zeta.token.categories.keywords.BooleanLiteralKeywordCategory;
import me.a8kj.zeta.token.categories.keywords.ControlKeywordCategory;
import me.a8kj.zeta.token.categories.keywords.DeclarationKeywordCategory;
import me.a8kj.zeta.token.impl.LexerToken;
import me.a8kj.zeta.tokenizer.TokenizerRule;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;

public class IdentifierRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        if (!context.hasNext())
            return false;
        char c = context.currentChar();
        return Character.isLetter(c) || c == '_' || c == '$';
    }
    

    @Override
    public Token apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        StringBuilder builder = new StringBuilder();

        while (context.hasNext()) {
            char c = context.currentChar();
            if (!Character.isLetterOrDigit(c) && c != '_' && c != '$')
                break;
            builder.append(c);
            context.advance();
        }

        String value = builder.toString();
        TokenLocation location = new TokenLocation(column, line, start, context.getPosition());

        Token keywordToken = matchKeyword(value, location);
        return keywordToken != null
                ? keywordToken
                : new LexerToken(value, IdentifierCategory.IDENTIFIER, location);
    }

    private Token matchKeyword(String value, TokenLocation location) {
        for (DeclarationKeywordCategory category : DeclarationKeywordCategory.values()) {
            if (category.value().equals(value)) {
                return new LexerToken(value, category, location);
            }
        }

        for (BooleanLiteralKeywordCategory category : BooleanLiteralKeywordCategory.values()) {
            if (category.value().equals(value)) {
                return new LexerToken(value, category, location);
            }
        }

        for (ControlKeywordCategory category : ControlKeywordCategory.values()) {
            if (category.value().equals(value)) {
                return new LexerToken(value, category, location);
            }
        }

        return null;
    }
}
