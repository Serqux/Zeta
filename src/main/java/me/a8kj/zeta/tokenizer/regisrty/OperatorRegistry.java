package me.a8kj.zeta.tokenizer.regisrty;

import me.a8kj.zeta.token.attributes.TokenCategory;
import me.a8kj.zeta.token.categories.operators.*;

import java.util.*;

public final class OperatorRegistry {
    private OperatorRegistry() {
    }

    private static final Map<String, TokenCategory> operators = new HashMap<>();

    static {
        register(ArithmeticOperatorCategory.values());
        register(AssignmentOperatorCategory.values());
        register(ComparisonOperatorCategory.values());
        register(LogicalOperatorCategory.values());
    }

    private static void register(TokenCategory[] categories) {
        for (TokenCategory category : categories) {
            operators.put(category.value(), category);
        }
    }

    public static boolean isOperator(String value) {
        return operators.containsKey(value);
    }

    public static Optional<TokenCategory> getCategory(String value) {
        return Optional.ofNullable(operators.get(value));
    }

    public static Set<String> allOperators() {
        return Collections.unmodifiableSet(operators.keySet());
    }

    public static boolean startsWithOperator(String input, int position) {
        for (String op : operators.keySet()) {
            if (input.startsWith(op, position)) {
                return true;
            }
        }
        return false;
    }

    public static Optional<String> matchOperator(String input, int position) {
        return operators.keySet().stream()
                .sorted(Comparator.comparingInt(String::length).reversed())
                .filter(op -> input.startsWith(op, position))
                .findFirst();
    }
}
