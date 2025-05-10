package me.a8kj.zeta.tokenizer.rules;

import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.token.attributes.TokenLocation;
import me.a8kj.zeta.token.categories.DelimiterCategory;
import me.a8kj.zeta.token.impl.LexerToken;
import me.a8kj.zeta.tokenizer.TokenizerRule;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;

public class DelimiterRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        char current = context.currentChar();
        for (DelimiterCategory delimiter : DelimiterCategory.values()) {
            if (delimiter.value().charAt(0) == current) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Token apply(TokenizerContext context) {
        int start = context.getPosition();
        int line = context.getLine();
        int column = context.getColumn();

        char current = context.currentChar();
        context.advance();

        for (DelimiterCategory delimiter : DelimiterCategory.values()) {
            if (delimiter.value().charAt(0) == current) {
                return new LexerToken(
                        String.valueOf(current),
                        delimiter,
                        new TokenLocation(column, line, start, context.getPosition())
                );
            }
        }

        throw new RuntimeException("Unknown delimiter: " + current + " at position " + start);
    }
}
