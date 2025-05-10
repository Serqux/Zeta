package me.a8kj.zeta.tokenizer;

import java.util.List;
import lombok.RequiredArgsConstructor;
import me.a8kj.zeta.token.Token;

@RequiredArgsConstructor
public abstract class AbstractTokenizer implements Tokenizer {
    protected final String input;
    protected int pos = 0;
    protected int line = 1;
    protected int lineStart = 0;

    public abstract List<Token> tokenize();

    protected boolean hasNext() {
        return pos < input.length();
    }

    protected char peek() {
        return peek(0);
    }

    protected char peek(int offset) {
        int index = pos + offset;
        return (index < input.length()) ? input.charAt(index) : '\0';
    }

    protected void advance() {
        if (!hasNext())
            return;

        char ch = input.charAt(pos++);
        if (ch == '\n') {
            line++;
            lineStart = pos;
        }
    }

    protected boolean match(char expected) {
        if (peek() == expected) {
            advance();
            return true;
        }
        return false;
    }

    protected int getColumn() {
        return pos - lineStart + 1;
    }
}
