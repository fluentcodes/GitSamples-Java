## [GitSamples](/../../tree/master) - [Behavioral](/../../tree/java-design-pattern/test/samples/behavioural): Interpreter Pattern
<cite>A design pattern that specifies how to evaluate sentences in a language. The basic idea is to have a class for each symbol (terminal or nonterminal) in a specialized computer language. The syntax tree of a sentence in the language is an instance of the composite pattern and is used to evaluate (interpret) the sentence for a client.</cite>

See also [Composite pattern](/../../tree/java-design-pattern/test/samples/structural/composite).

### Problems
* A grammar for a simple language should be defined
    so that sentences in the language can be interpreted.

When a problem occurs very often, it could be considered to represent it as a sentence in a simple language (Domain Specific Languages) so that an interpreter can solve the problem by interpreting the sentence.

For example, when many different or complex search expressions must be specified. Implementing (hard-wiring) them directly into a class is inflexible because it commits the class to particular expressions and makes it impossible to specify new expressions or change existing ones independently from (without having to change) the class.

### Solution
* Define a grammar for a simple language by defining an Expression class hierarchy and implementing an interpret() operation. 
* Represent a sentence in the language by an abstract syntax tree (AST) made up of Expression instances.
* Interpret a sentence by calling interpret() on the AST.

The expression objects are composed recursively into a composite/tree structure that is called abstract syntax tree (see Composite pattern).

The Interpreter pattern doesn't describe how to build an abstract syntax tree. This can be done either manually by a client or automatically by a parser.



### Examples
Here we have a simple [sql](sql) interpreter here.

### Links
* https://en.wikipedia.org/wiki/Interpreter_pattern
* https://en.wikipedia.org/wiki/Behavioral_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://www.baeldung.com/java-interpreter-pattern
* https://www.journaldev.com/1635/interpreter-design-pattern-java
