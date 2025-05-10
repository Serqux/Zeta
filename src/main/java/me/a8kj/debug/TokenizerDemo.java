package me.a8kj.debug;

import me.a8kj.debug.reader.ZetaFileReader;
import me.a8kj.debug.reader.ZeteFileReaderImpl;
import me.a8kj.zeta.token.Token;
import me.a8kj.zeta.tokenizer.impl.SimpleTokenizer;

import java.io.InputStream;
import java.util.List;

public class TokenizerDemo {
    public static void main(String[] args) {
        InputStream scriptStream = TokenizerDemo.class.getClassLoader().getResourceAsStream("supported.zeta");
        ZetaFileReader zetaFileReader = new ZeteFileReaderImpl(scriptStream);

        if (!zetaFileReader.isValid()) {
            System.err.println("Failed to load script.zeta from resources.");
            return;
        }

        String code = zetaFileReader.read();
        if (code.isEmpty())
            throw new IllegalArgumentException("file is empty !");
        System.out.println("Loaded code:\n" + code);

        SimpleTokenizer tokenizer = new SimpleTokenizer(code);
        List<Token> tokens = tokenizer.tokenize();

        System.out.println("\nTokens:");
        System.out.printf("%-4s %-15s %-20s %-6s %-7s%n", "#", "Type", "Value", "Line", "Column");
        System.out.println("-------------------------------------------------------------");

        int index = 1;
        for (Token token : tokens) {
            System.out.printf(
                "%-4d %-15s %-20s %-6d %-7d%n",
                index++,
                token.getKind().name(),
                token.getValue(),
                token.getLocation().getLine(),
                token.getLocation().getColumn()
            );
        }
    }
}
