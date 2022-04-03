## [GitSamples](/../../tree/master) - [Behavioral](/../../tree/java-design-pattern/test/samples/behavioural): Iterator Pattern
<cite>A design pattern in which an iterator is used to traverse a container and access the container's elements. The iterator pattern decouples algorithms from containers</cite>

### Problems
* The elements of an aggregate object should be accessed and traversed without exposing its representation (data structures).
* New traversal operations should be defined for an aggregate object without changing its interface.

Defining access and traversal operations in the aggregate interface is inflexible because it commits the aggregate to particular access and traversal operations and makes it impossible to add new operations later without having to change the aggregate interface.

### Solution
* Define a separate (iterator) object that encapsulates accessing and traversing an aggregate object.
* Clients use an iterator to access and traverse an aggregate without knowing its representation (data structures).

Different iterators can be used to access and traverse an aggregate in different ways.
New access and traversal operations can be defined independently by defining new iterators.

### Examples 
There is one example in the Topic Path [treasure](treasure).
### Links
* https://en.wikipedia.org/wiki/Iterator_pattern
* https://en.wikipedia.org/wiki/Behavioral_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://java-design-patterns.com/patterns/iterator/
* https://www.javatpoint.com/iterator-pattern
* https://howtodoinjava.com/design-patterns/behavioral/iterator-design-pattern/