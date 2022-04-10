## [GitSamples](/../../tree/master) - [Functional Programming](/../../tree/java-8/test/samples/functional): BiFunction
<cite>Represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function. </cite>

### BiFunction
    @FunctionalInterface
    public interface BiFunction<T, U, R> {
      R apply(T t, U u);
    }

* T – Type of the first argument to the function.
* U – Type of the second argument to the function.
* R – Type of the result of the function.

Especially useful are BiConsumer for the new [foreach method in maps](MapForeachTest.java).

#### Test Examples
* [BiFunctionTest](BiFunctionTest): Simple Examples.
* [MapComputeTest](MapComputeTest.java): Tests for Map.compute and Map.computeIfPresent methods.

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
* https://mkyong.com/java8/java-8-bifunction-examples/
* https://www.baeldung.com/java-bifunction-interface
* https://javabydeveloper.com/java-bifunction-guide-examples/

### ToDoubleBiFunction

    @FunctionalInterface
    interface ToDoubleBiFunction<T, U> {
       double applyAsDouble(T t, U u);
    }

#### Examples
[ToDoubleBiFunctionTest](ToDoubleBiFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/ToDoubleBiFunction.html
* https://www.tutorialspoint.com/how-to-implement-todoublebifunction-t-u-using-lambda-expression-in-java
* https://www.generacodice.com/es/articolo/2326313/How-to-implement-ToDoubleBiFunctionlt;T,-Ugt;-using-lambda-expression-in-Java?a=r
* https://www.programcreek.com/java-api-examples/?api=java.util.function.ToDoubleBiFunction
* http://www.java2s.com/Tutorials/Java/java.util.function/ToDoubleBiFunction/index.htm
* https://developers.google.com/j2objc/javadoc/jre/reference/java/util/function/ToDoubleBiFunction




### ToIntBiFunction

    @FunctionalInterface
    interface ToIntBiFunction<T, U> {
       long applyAsInt(T t, U u);
    }

#### Examples
[ToIntBiFunctionTest](ToIntBiFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/ToIntBiFunction.html




### ToLongBiFunction

    @FunctionalInterface
    interface ToLongBiFunction<T, U> {
       long applyAsLong(T t, U u);
    }

#### Examples
[ToLongBiFunctionTest](ToLongBiFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/ToLongBiFunction.html
