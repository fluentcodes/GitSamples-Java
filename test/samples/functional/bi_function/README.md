## [GitSamples](/../../tree/master) - [Functional Programming](/../../tree/java-8/test/samples/functional): BiFunction
<cite>Represents a function that accepts two arguments and produces a result. This is the two-arity specialization of Function. </cite>

    @FunctionalInterface
    public interface BiFunction<T, U, R> {
      R apply(T t, U u);
    }

* T – Type of the first argument to the function.
* U – Type of the second argument to the function.
* R – Type of the result of the function.

Especially useful are BiConsumer for the new [foreach method in maps    ](MapForeachTest.java).

### Test Examples
* [BiFunctionTest](BiFunctionTest): Simple Examples.
* [MapComputeTest](MapComputeTest.java): Tests for Map.compute and Map.computeIfPresent methods.

### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/BiFunction.html
* https://mkyong.com/java8/java-8-bifunction-examples/
* https://www.baeldung.com/java-bifunction-interface
* https://javabydeveloper.com/java-bifunction-guide-examples/
