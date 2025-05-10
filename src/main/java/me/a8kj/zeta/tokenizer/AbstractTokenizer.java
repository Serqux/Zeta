package me.a8kj.zeta.tokenizer;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;

@RequiredArgsConstructor
public abstract class AbstractTokenizer implements Tokenizer {
    protected final String input;

    public abstract List<Token> tokenize();

    protected TokenizerContext createContext() {
        return new TokenizerContext(input);
    }
} 
