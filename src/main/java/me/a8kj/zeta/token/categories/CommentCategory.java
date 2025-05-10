package me.a8kj.zeta.token.categories;

import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.attributes.TokenCategory;

@RequiredArgsConstructor
public enum CommentCategory implements TokenCategory {
    SINGLE_LINE("#"),
    MULTI_LINE("/# #/");

    private final String value;

    @Override
    public String value() {
        return value;
    }

    @Override
    public CategoryKind kind() {
        return CategoryKind.COMMENT;
    }
}
