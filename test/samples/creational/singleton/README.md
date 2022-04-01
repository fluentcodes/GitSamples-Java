## [GitSamples](/../../tree/master) - [Creational](/../../tree/java-design-pattern/test/samples/creational): Singelton Pattern

### Problem

* Ensure that a class only has one instance 
* Easily access the sole instance of a class
* Control its instantiation 
* Restrict the number of instances
* Access a global variable

### Solution
* Hide the constructors of the class.
* Define a public static operation (getInstance()) that returns the sole instance of the class.

### Usage
Logging is a classic example of a singleton.
* The abstract factory, factory method, builder, and prototype patterns can use singletons.
* Facade objects are often singletons because only one facade object is required. 
* State objects are often singletons.
* Singletons are often preferred to global variables because:
  * They do not pollute the global namespace (or, in languages with nested namespaces, their containing namespace) with unnecessary variables.
  * They permit lazy allocation and initialization, whereas global variables in many languages will always consume resources.

### Examples
[Singelton](Singleton.java) implements a singelton with a value which could be set. 

Within [SingeltonTest](SingletonTest.java) one test change this value and 
it's been changed in the other test.

### Links
* https://en.wikipedia.org/wiki/Singleton_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://en.wikipedia.org/wiki/Creational_pattern
