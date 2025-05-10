package me.a8kj.zeta.token.categories.keywords;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.attributes.TokenCategory;

@RequiredArgsConstructor
@Getter
public enum BooleanLiteralKeywordCategory implements TokenCategory {
    TRUE("true"),
    FALSE("false");

    private final String value;

    @Override
    public String value() {
        return value;
    }

    @Override
    public CategoryKind kind() {
        return CategoryKind.KEYWORD;
    }
}
