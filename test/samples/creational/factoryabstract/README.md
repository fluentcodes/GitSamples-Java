## [GitSamples](/../../tree/master) - [Creational](/../../tree/java-design-pattern/test/samples/creational): Abstract Factory Pattern
<cite>The abstract factory pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes.</cite>

### Problems
The Abstract Factory design pattern solves problems like: [4]
* How can an application be independent of how its objects are created? 
* How can a class be independent of how the objects it requires are created?
* How can families of related or dependent objects be created?

### Examples
We have an generic [AbstractFactory](AbstractFactory.java) with the two implementations
* [ColorFactory](ColorFactory.java) providing [Color](Color.java) objects
* [FormsFactory](FormFactory.java) providing [Forms](Forms.java) objects

The  [AbstractFactoryTest](AbstractFactoryTest.java) shows some usages. 


### Links
* https://www.baeldung.com/java-abstract-factory-pattern
* https://en.wikipedia.org/wiki/Abstract_factory_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://en.wikipedia.org/wiki/Creational_pattern
