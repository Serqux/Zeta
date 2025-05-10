package me.a8kj.zeta.token.categories;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.attributes.TokenCategory;

@Getter
@RequiredArgsConstructor
public enum DelimiterCategory implements TokenCategory {
    SEMICOLON(";"),
    COMMA(","),
    PAREN_OPEN("("),
    PAREN_CLOSE(")"),
    BRACE_OPEN("{"),
    BRACE_CLOSE("}");

    private final String value;

    @Override
    public String value() {
        return value;
    }

    @Override
    public CategoryKind kind() {
        return CategoryKind.DELIMITER;
    }
}
