package me.a8kj.zeta.token.attributes;

public interface TokenCategory {

    String name();

    String value();

    CategoryKind kind();

    enum CategoryKind {
        /**
         * Mathematical and logical operators (+, -, *, /, ==, !=, etc.)
         */
        OPERATOR,

        /**
         * Reserved language keywords (if, while, return, etc.)
         */
        KEYWORD,

        /**
         * Symbols that structure code (braces, semicolons, commas, etc.)
         */
        DELIMITER,

        /**
         * Identifiers such as variable names or function names.
         */
        IDENTIFIER,

        /**
         * Literals like numbers, strings, characters.
         */
        LITERAL,

        /**
         * Comments in the code (ignored during execution).
         */
        COMMENT,

        /**
         * Marks the end of the file/input stream.
         */
        EOF
    }
}
