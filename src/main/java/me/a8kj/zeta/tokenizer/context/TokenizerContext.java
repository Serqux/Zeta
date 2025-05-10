package me.a8kj.zeta.tokenizer.context;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@RequiredArgsConstructor
@Setter
public class TokenizerContext {
    private final String input;
    private int position = 0;
    private int line = 1;
    private int lineStart = 0;

    public boolean hasNext() {
        return position < input.length();
    }

    public char currentChar() {
        return input.charAt(position);
    }

    public char peek() {
        return (position + 1 < input.length()) ? input.charAt(position + 1) : '\0';
    }

    public void advance() {
        if (!hasNext())
            return;

        char ch = input.charAt(position++);
        if (ch == '\n') {
            line++;
            lineStart = position;
        }
    }

    public String substring(int start, int end) {
        return input.substring(start, end);
    }

    public int getColumn() {
        return position - lineStart + 1;
    }
}
