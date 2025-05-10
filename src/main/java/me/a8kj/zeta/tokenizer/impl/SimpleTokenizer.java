package me.a8kj.zeta.tokenizer.impl;

import java.util.ArrayList;
import java.util.List;
import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.tokenizer.AbstractTokenizer;
import me.a8kj.zeta.tokenizer.TokenizerRule;
import me.a8kj.zeta.tokenizer.context.TokenizerContext;
import me.a8kj.zeta.tokenizer.regisrty.RuleRegistry;

public class SimpleTokenizer extends AbstractTokenizer {

    private static final List<TokenizerRule> rules = RuleRegistry.getRules();

    public SimpleTokenizer(String input) {
        super(input);
    }

    @Override
    public List<Token> tokenize() {

        if (input.isEmpty() || input == null)
            throw new IllegalStateException("loaded code cannot be empty bud!");

        TokenizerContext context = new TokenizerContext(input);
        List<Token> tokens = new ArrayList<>();

        while (context.hasNext()) {
            boolean matched = false;

            for (TokenizerRule rule : rules) {
                if (rule.matches(context)) {
                    Token token = rule.apply(context);
                    if (token != null) {
                        tokens.add(token);
                    }
                    matched = true;
                    break;
                }
            }

            if (!matched) {
                char unknownChar = context.currentChar();
                int line = context.getLine();
                int column = context.getColumn();
                throw new RuntimeException(
                        "Unknown character: '" + unknownChar + "' at line " + line + ", column " + column);
            }
        }

        return tokens;
    }
}
