## [GitSamples](/../../tree/master) - [Functional Programming](/../../tree/java-8/test/samples/functional): BinaryOperator
<cite>Represents an operation upon two operands of the same type, producing a result of the same type as the operands. This is a specialization of BiFunction for the case where the operands and the result are all of the same type. </cite>

    @FunctionalInterface
    public interface BinaryOperator<T> extends BiFunction<T,T,T> {
    }

* T – Type of the BinaryOperator.

This is a special case for BiFunction where the two input values and the result have the same type.

Untyped special operators are
* DoubleBinaryOperator
* IntBinaryOperator
* LongBinaryOperator

### Test Examples

* [BinaryOperatorTest](BinaryOperatorTest)
* [DoubleBinaryOperatorTest](DoubleBinaryOperatorTest)
* [IntBinaryOperatorTest](IntBinaryOperatorTest)
* [LongBinaryOperatorTest](LongBinaryOperatorTest)

### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/function/BinaryOperator.html
* https://mkyong.com/java8/java-8-binaryoperator-examples/
* http://www.java2s.com/Tutorials/Java/java.util.function/BinaryOperator/index.htm
* https://www.geeksforgeeks.org/binaryoperator-interface-in-java/
#### DoubleBinaryOperator
* https://docs.oracle.com/javase/8/docs/api/java/util/function/DoubleBinaryOperator.html
* https://www.geeksforgeeks.org/java-util-function-doublebinaryoperator-interface-with-examples/
* http://www.java2s.com/Tutorials/Java/java.util.function/DoubleBinaryOperator/index.htm
* https://www.programcreek.com/java-api-examples/?api=java.util.function.DoubleBinaryOperator

#### IntBinaryOperator
* https://docs.oracle.com/javase/8/docs/api/java/util/function/IntBinaryOperator.html
#### LongBinaryOperator
* https://docs.oracle.com/javase/8/docs/api/java/util/function/LongBinaryOperator.html