package me.a8kj.zeta.tokenizer.impl;

import java.util.ArrayList;
import java.util.List;

import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.tokenizer.AbstractTokenizer;

public class SimpleTokenizer extends AbstractTokenizer {

    public SimpleTokenizer(String input) {
        super(input);
    }

    @Override
    public List<Token> tokenize() {
        List<Token> tokens = new ArrayList<>();
        return tokens;
    }

}
