package me.a8kj.zeta.tokenizer;

import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;

public interface TokenizerRule {
    boolean matches(TokenizerContext context);

    Token apply(TokenizerContext context);
}
