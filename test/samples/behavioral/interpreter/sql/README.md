## [GitSamples](/../../tree/master) - [State Pattern](/../../tree/java-design-pattern/test/samples/behavioural/state): Package Delivery Example

In [Context](Context) we have a simple hashmap for data. Furthermore it contains an instance of 
* [Select](Select.java),
* [From](From.java) and
* [Where](Where.java)

implementing [Expression](Expression) with the method interprete.



### Tests
In [InterpreterTest](InterpreterTest.java) we find some tests for some interpreted constructs, e.g.

    Expression query = new Select("name", new From("people"));
    Context ctx = new Context();
    List<String> result = query.interpret(ctx);
### Links
* https://www.baeldung.com/java-interpreter-pattern