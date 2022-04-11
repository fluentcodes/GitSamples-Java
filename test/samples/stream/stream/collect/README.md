## [GitSamples](/../../tree/master) - [Java8](/../../tree/java-8) [Streams](/../../tree/java-8/test/samples/stream): Collect

    <T> T collect(Supplier<T> supplier, BiConsumer<T,? super U> accumulator, BiConsumer<T,T> combiner)
    <R,A> R collect(Collector<? super T,A,R> collector)

### Examples
* [CollectorTest](CollectorTest.java)
* [CollectorListTest](CollectorListTest.java)
* [CollectToMapTest](CollectorToMapTest.java): Creating Maps from Lists

### Links
* https://docs.oracle.com/javase/8/docs/api/java/util/stream/Stream.html
