package me.a8kj.zeta.tokenizer.rules;

import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.tokenizer.TokenizerRule;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;

public class WhitespaceSkippingRule implements TokenizerRule {

    @Override
    public boolean matches(TokenizerContext context) {
        char c = context.currentChar();
        return Character.isWhitespace(c);
    }

    @Override
    public Token apply(TokenizerContext context) {
        while (context.hasNext() && Character.isWhitespace(context.currentChar())) {
            context.advance();
        }
        return null;
    }

}
