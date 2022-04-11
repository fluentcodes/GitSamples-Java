## [GitSamples](/../../tree/master) - [Streams](/../../tree/java-8/test/samples/stream): Stream
A stream represents a sequence of elements and supports different kind of operations to perform computations upon those elements:

Stream operations are either intermediate or terminal.
Intermediate operations return a stream so we can chain multiple intermediate operations without using semicolons.
Terminal operations are either void or return a non-stream result.

Such a chain of stream operations is also known as operation pipeline.
### Intermediate Operations
* [distinct](distinct)
* [filter](filter)
* [flatmap](flatmap)
* [map](map)
* [mapToInt](mapToInt): Convert to primitive type to prepare toArray method
* [peek](peek)
* [sorted](sorted)

### Terminal Opoerations
* [collect](collect)
* [forEach](for_each)
* [toArray](to_array)

### Examples
* [StreamTest](StreamTest.java)

#### Misc
* [enemenemu](examples/enemenemu)
* [filter with object](examples/example_filter_map_person)
* [prime numbers](examples/PrimeFactorsExampleTest.java)
* 
### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/stream/package-summary.html
* https://stackify.com/streams-guide-java-8/
* https://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
* https://www.baeldung.com/java-8-streams
* https://ertan-toker.de/java-streams-tutorial-and-examples/
