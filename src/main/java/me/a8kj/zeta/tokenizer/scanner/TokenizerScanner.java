package me.a8kj.zeta.tokenizer.scanner;

import me.a8kj.zeta.tokenizer.context.TokenizerContext;
import me.a8kj.zeta.tokenizer.scanner.attributes.ScannerKind;

public interface TokenizerScanner<Result> {
    ScannerKind getKind();

    Result tokenize(TokenizerContext context);
}
