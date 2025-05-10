package me.a8kj.zeta.tokenizer;

import java.util.List;

import me.a8kj.zeta.token.Token;

public interface Tokenizer {
    List<Token> tokenize();
}
