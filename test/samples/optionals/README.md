## [GitSamples](/../../tree/master) - [Java8](/../../tree/java-8): Optional

Optional is a container object which is used to contain not-null objects. Optional object is used to represent null with absent value. 

This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.

### Examples
Actually one main test [OptionalTest](OptionalTest.java). 

The test in [OptionalFlatMapTest](flatMap/OptionalFlatMapTest.java) with flatMap method uses the classes 
* [Outer](flatMap/Outer.java) contains [Nested](flatMap/Nested.java)
* [Nested](flatMap/Nested.java) contains  [Inner](flatMap/Inner.java)
* [Inner](flatMap/Inner.java) contains String

In [OptionalIntTest](OptionalIntTest.java) there is one test for primitive int values. 

### Links
* https://www.baeldung.com/java-optional
* https://javarevisited.blogspot.com/2017/04/10-examples-of-optional-in-java-8.html#axzz7PV2YZzuU
* https://www.callicoder.com/java-8-optional-tutorial/
* https://www.baeldung.com/java-avoid-null-check
* http://www.tutorialspoint.com/java8/java8_optional_class.htm

