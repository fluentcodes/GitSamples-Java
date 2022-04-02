## [GitSamples](/../../tree/master) - [Creational](/../../tree/java-design-pattern/test/samples/creational): Prototype Pattern
This pattern is valid, when  an existing object with all its values 
is copied. This is different creating an empty instance.

### Problems
* How can objects be created so that which objects to create can be specified at run-time?
* How can dynamically loaded classes be instantiated?

Creating objects directly within the class that requires (uses) the objects is inflexible because it commits the class to particular objects at compile-time and makes it impossible to specify which objects to create at run-time.

### Solution
* Define a Prototype object that returns a copy of itself.
* Create new objects by copying a Prototype object.

### Examples
The example classes 
* [Prototype1](Prototype1.java)
* [Prototype2](Prototype2.java)
implements the abstract class [Prototype](Prototype.java) which has a string value as instance var. It implement the Cloneable interface with the clone method. 

One Test is provided in [PrototypeTest](PrototypeTest.java)



### Links
* https://en.wikipedia.org/wiki/Prototype_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://en.wikipedia.org/wiki/Creational_pattern
* https://de.wikipedia.org/wiki/Prototyp_(Entwurfsmuster)
