# Zeta
Zeta is a lightweight, minimal programming language inspired by assembly, created purely as a test and learning experiment.


### Current Status Notes:

Right now, the tokenizer is rule-based, and I'm working on improving several parts:

* Some rules overlap or conflict, so I need to refine their order and nesting for more accurate tokenization.
* Planning to better utilize the Tokenizer Scanner, especially for handling identifiers with symbols like `_` and `$`.
* Not everything is supported yet—strings, for example, aren't implemented, so unsupported scripts might be partially skipped.
* There's currently no error handling, so I need to add proper diagnostics to track and explain issues during tokenization.
* TokenizerContext needs to be smarter and include state management to support more complex parsing scenarios.
* RuleRegistry order currently controls everything, which makes it fragile; I’m looking into a smarter way to manage rules.


