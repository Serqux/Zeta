package me.a8kj.zeta.token.categories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.attributes.TokenCategory;

@RequiredArgsConstructor
@Getter
public enum LiteralCategory implements TokenCategory {
    NUMBER("let"),
    STRING("string"),
    CHARACTER("char"),
    BOOLEAN("bool");

    private final String value;

    @Override
    public String value() {
        return value;
    }

    @Override
    public CategoryKind kind() {
        return CategoryKind.LITERAL;
    }
}
