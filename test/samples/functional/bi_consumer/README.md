## [GitSamples](/../../tree/master) - [Functional Programming](/../../tree/java-8/test/samples/function): BiConsumer
<cite>Represents an operation that accepts two input arguments and returns no result. This is the two-arity specialization of Consumer. Unlike most other functional interfaces, BiConsumer is expected to operate via side-effects.</cite>

    @FunctionalInterface
    public interface BiConsumer<T, U> {
      void accept(T t, U u);
    }


Especially useful are BiConsumer for the new [foreach method in maps    ](MapForeachTest.java).

### Test Examples
* [BiConsumerTest](BiConsumerTest): Simple Examples.
* [MapForeachTest](MapForeachTest.java): One test for Map.foreach method.

### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/BiConsumer.html
* https://mkyong.com/java8/java-8-biconsumer-examples/
* https://www.geeksforgeeks.org/java-8-biconsumer-interface-in-java-with-examples/
