## [GitSamples](/../../tree/master) - [Structural](/../../tree/java-design-pattern/test/samples/structural): Facade Pattern
<cite>When we have to start a computer, all we have to do is press the start button. We really do not care what all things go inside the computer hardware and software. It is an example of Facade pattern.</cite>

A Facade is used when an easier or simpler interface to an underlying object is desired.

Alternatively, an adapter can be used when the wrapper must respect a particular interface and must support polymorphic behavior. A decorator makes it possible to add or alter behavior of an interface at run-time.
Pattern 	Intent
* [Adapter](/../../tree/java-design-pattern/test/samples/structural/adapter): Converts one interface to another so that it matches what the client is expecting
* [Decorator](/../../tree/java-design-pattern/test/samples/structural/decorator): Dynamically adds responsibility to the interface by wrapping the original code
* Facade: Provides a simplified interface

The facade pattern is typically used when

* a simple interface is required to access a complex system,
* a system is very complex or difficult to understand, 
* an entry point is needed to each level of layered software, or
* the abstractions and implementations of a subsystem are tightly coupled.

### Examples
In the example we define a [MenueFacade](MenuAdapter.java) with the methods
* showMenu1: For [Menu1](Menu1.java)
* showMenu2: For [Menu2](Menu2.java)
* showMenu2: For [Menu3](Menu3.java)

When running [MenueFacadeTest](MenuFacadeTest.java) it has the following output:
    
    Menu1
    Menu2
    Menu3

### Links
* https://www.geeksforgeeks.org/facade-design-pattern-introduction/
* https://javapapers.com/design-patterns/facade-design-pattern/
* https://programmingline.com/software-design-patterns/facade-design-pattern
* https://howtodoinjava.com/design-patterns/structural/facade-design-pattern/
* https://en.wikipedia.org/wiki/Facade_pattern
* https://en.wikipedia.org/wiki/Structural_pattern
* https://en.wikipedia.org/wiki/Software_design_pattern
* https://de.wikipedia.org/wiki/Fassade_(Entwurfsmuster)