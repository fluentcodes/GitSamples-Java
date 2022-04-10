## [GitSamples](/../../tree/master) - [Functional Programming](/../../tree/java-8/test/samples/functional): To Function
<cite>Represents a function that accepts one argument and produces a result. </cite>

### Function

    @FunctionalInterface
    public interface Function<T> {
      Double apply(T t);
    }


#### Examples
* [FunctionTest](FunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/Function.html
* https://mkyong.com/java8/java-8-function-examples/
* https://www.javabrahman.com/java-8/java-8-java-util-function-function-tutorial-with-examples/
* https://www.geeksforgeeks.org/function-interface-in-java-with-examples/
* https://javabydeveloper.com/java-8-function-and-examples/







### DoubleFunction

    @FunctionalInterface
    public interface DoubleFunction<T> {
      T apply(double d);
    }


#### Examples
* [DoubleFunctionTest](DoubleFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/DoubleFunction.html







### ToDoubleFunction

    @FunctionalInterface
    public interface ToDoubleFunction<T> {
      double applyAsDouble(T t);
    }

#### Examples
* [ToDoubleFunctionTest](ToDoubleFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/ToDoubleFunction.html
* https://docs.oracle.com/javase/8/docs/api/java/util/function/ToDoubleFunction.html
* https://www.geeksforgeeks.org/todoublefunction-interface-in-java-with-examples/
* https://www.tutorialspoint.com/how-to-implement-todoublefunction-t-using-lambda-expression-in-java
* http://www.java2s.com/Tutorials/Java/java.util.function/ToDoubleFunction/index.htm


### IntToDoubleFunction

    @FunctionalInterface
    public interface IntToDoubleFunction<T> {
      double applyAsDouble(T t);
    }

Directly transforms a IntStream to a DoubleStream:

    final IntToDoubleFunction FUNCTION = i -> Double.valueOf(i)/3;
    IntStream intStream = Arrays.stream(new int[]{1, 2, 3});
    DoubleStream doubleStream = intStream.mapToDouble(FUNCTION::applyAsDouble);

#### Examples
* [IntToDoubleFunctionTest](IntToDoubleFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/IntToDoubleFunction.html



### LongToDoubleFunction

    @FunctionalInterface
    public interface LongToDoubleFunction<T> {
      double applyAsDouble(T t);
    }

Directly transforms a LongStream to a DoubleStream:

    final LongToDoubleFunction FUNCTION = i -> Double.valueOf(i) / 3;
    LongStream longStream = Arrays.stream(new long[]{1L, 2L, 3L});
    DoubleStream doubleStream = longStream.mapToDouble(FUNCTION::applyAsDouble);

#### Examples
* [LongToDoubleFunctionTest](LongToDoubleFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/LongToDoubleFunction.html




### IntFunction

    @FunctionalInterface
    public interface IntFunction<T> {
      T apply(double l);
    }

#### Examples
* [IntFunctionTest](IntFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/IntFunction.html





### ToIntFunction

    @FunctionalInterface
    public interface ToIntFunction<T> {
      integer applyAsInt(T t);
    }


#### Examples
* [ToIntFunctionTest](ToIntFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/ToIntFunction.html


### DoubleToIntFunction

    @FunctionalInterface
    public interface DoubleToIntFunction<T> {
      integer applyAsInt(T t);
    }


#### Examples
* [DoubleToIntFunctionTest](DoubleToIntFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/DoubleToIntFunction.html



### LongToIntFunction

    @FunctionalInterface
    public interface LongToIntFunction<T> {
      integer applyAsInt(T t);
    }


#### Examples
* [LongToIntFunctionTest](LongToIntFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/LongToIntFunction.html


### LongFunction

    @FunctionalInterface
    public interface LongFunction<T> {
      T apply(long l);
    }

#### Examples
* [LongFunctionTest](LongFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/LongFunction.html




### ToLongFunction

    @FunctionalInterface
    public interface ToIntFunction<T> {
      long applyAsLong(T t);
    }

#### Examples
* [ToLongFunctionTest](ToLongFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/ToLongFunction.html




### IntToLongFunction

    @FunctionalInterface
    public interface IntToLongFunction {
      long applyAsLong(int i);
    }

#### Examples
* [IntToLongFunctionTest](IntToLongFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/IntToLongFunction.html



### DoubleToLongFunction

    @FunctionalInterface
    public interface DoubleToLongFunction {
      long applyAsLong(double i);
    }

#### Examples
* [DoubleToLongFunctionTest](DoubleToLongFunctionTest.java)

#### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/DoubleToLongFunction.html
