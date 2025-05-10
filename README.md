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



### ✅ Supported Example

Here’s a sample Zeta script that is currently fully supported by the tokenizer:

```rust
let $counter = 0;

if ($counter < 10) {
    $counter = $counter + 1;
    print(_name);
}

let isReady = true;
if (isReady) {
    doSmth();
}
```

And here’s the corresponding token output:

```
#    Type           Value         Line   Column
------------------------------------------------
1    LET            let           1      1
2    IDENTIFIER     $counter      1      5
3    ASSIGN         =             1      14
4    NUMBER         0             1      16
5    SEMICOLON      ;             1      17
6    IF             if            3      1
7    PAREN_OPEN     (             3      4
8    IDENTIFIER     $counter      3      5
9    LESS           <             3      14
10   NUMBER         10            3      16
11   PAREN_CLOSE    )             3      18
12   BRACE_OPEN     {             3      20
13   IDENTIFIER     $counter      4      5
14   ASSIGN         =             4      14
15   IDENTIFIER     $counter      4      16
16   PLUS           +             4      25
17   NUMBER         1             4      27
18   SEMICOLON      ;             4      28
19   IDENTIFIER     print         5      5
20   PAREN_OPEN     (             5      10
21   IDENTIFIER     _name         5      11
22   PAREN_CLOSE    )             5      16
23   SEMICOLON      ;             5      17
24   BRACE_CLOSE    }             6      1
25   LET            let           8      1
26   IDENTIFIER     isReady       8      5
27   ASSIGN         =             8      13
28   TRUE           true          8      15
29   SEMICOLON      ;             8      19
30   IF             if            9      1
31   PAREN_OPEN     (             9      4
32   IDENTIFIER     isReady       9      5
33   PAREN_CLOSE    )             9      12
34   BRACE_OPEN     {             9      14
35   IDENTIFIER     doSmth        10     5
36   PAREN_OPEN     (             10     11
37   PAREN_CLOSE    )             10     12
38   SEMICOLON      ;             10     13
39   BRACE_CLOSE    }             11     1
```

---

### ❌ Unsupported Example

If we try the following code:

```rust
let $counter = 0;
let _name = "ZetaLang";

if ($counter < 10) {
    $counter = $counter + 1;
    print(_name);
}

# comment

/#
comment
#/

let isReady = true;
if (isReady) {
    runTask("Compile"); 
}
```

The tokenizer throws an error due to unsupported features like string literals:

```
Exception in thread "main" java.lang.RuntimeException: Unknown character: '"' at line 2, column 13
    at me.a8kj.zeta.tokenizer.impl.SimpleTokenizer.tokenize(SimpleTokenizer.java:46)
    at me.a8kj.debug.TokenizerDemo.main(TokenizerDemo.java:28)
```

As you can see, the tokenizer stops processing when it encounters an unknown or unsupported token, which is another limitation that needs improvement. Handling of string literals, comments, and better error recovery are all planned enhancements.

