package me.a8kj.zeta.token.categories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.attributes.TokenCategory;

@RequiredArgsConstructor
@Getter
public enum IdentifierCategory implements TokenCategory {
    IDENTIFIER("identifier");
    // ymkn a3ml add // function lanh al identifier ya ema function name of variable 

    private final String value;

    @Override
    public CategoryKind kind() {
        return CategoryKind.IDENTIFIER;
    }

    @Override
    public String value() {
        return value;
    }
}
