package me.a8kj.zeta.token.scanner;

import lombok.NonNull;
import me.a8kj.utils.regex.RegexScanner;

public class IdentifierNameScanner extends RegexScanner {

    private static final String REGEX = "^[a-zA-Z_$][a-zA-Z\\d_$]*$";

    public IdentifierNameScanner() {
        super(REGEX);
    }

    public IdentifierNameScanner(@NonNull String text) {
        super(REGEX, text);
    }
}
