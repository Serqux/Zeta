package me.a8kj.zeta.token.categories.operators;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.attributes.TokenCategory;

@RequiredArgsConstructor
@Getter
public enum ComparisonOperatorCategory implements TokenCategory {
    EQUALS("=="),
    NOT_EQUALS("!="),
    GREATER(">"),
    LESS("<"),
    GREATER_EQUALS(">="),
    LESS_EQUALS("<=");

    private final String value;

    @Override
    public String value() {
        return value;
    }

    @Override
    public CategoryKind kind() {
        return CategoryKind.OPERATOR;
    }
}
