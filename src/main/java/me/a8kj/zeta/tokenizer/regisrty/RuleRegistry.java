package me.a8kj.zeta.tokenizer.regisrty;

import me.a8kj.zeta.tokenizer.TokenizerRule;
import me.a8kj.zeta.tokenizer.rules.*;

import java.util.List;

public final class RuleRegistry {

    private RuleRegistry() {
    }

    private static final List<TokenizerRule> rules = List.of(
            new WhitespaceSkippingRule(),
            new IdentifierRule(),
            new KeywordRule(),
            new NumberRule(),
            new OperatorRule(),
            new DelimiterRule());

    public static List<TokenizerRule> getRules() {
        return rules;
    }
}
