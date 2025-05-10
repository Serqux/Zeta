package me.a8kj.zeta.token;

import me.a8kj.zeta.token.attributes.TokenCategory;
import me.a8kj.zeta.token.attributes.TokenLocation;

public interface Token {

    String getValue();

    Enum<? extends TokenCategory> getKind();

    TokenLocation getLocation();

}
