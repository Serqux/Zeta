package me.a8kj.zeta.token.categories.operators;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.attributes.TokenCategory;

@RequiredArgsConstructor
@Getter
public enum AssignmentOperatorCategory implements TokenCategory {
    ASSIGN("="),
    PLUS_ASSIGN("+="),
    MINUS_ASSIGN("-="),
    MULTIPLY_ASSIGN("*="),
    DIVIDE_ASSIGN("/="),
    MODULO_ASSIGN("%=");

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
