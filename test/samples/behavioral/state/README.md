## [GitSamples](/../../tree/master) - [Behavioral](/../../tree/java-design-pattern/test/samples/behavioural): State Pattern
<cite>Allows an object to alter its behavior when its internal state changes. This pattern is close to the concept of finite-state machines. The state pattern can be interpreted as a strategy pattern, which is able to switch a strategy through invocations of methods defined in the pattern's interface.</cite>

### Problems

* An object should change its behavior when its internal state changes.
* State-specific behavior should be defined independently. That is, adding new states should not affect the behavior of existing states.

Implementing state-specific behavior directly within a class is inflexible because it commits the class to a particular behavior and makes it impossible to add a new state or change the behavior of an existing state later, independently from the class, without changing the class. 


### Solution
* Define separate (state) objects that encapsulate state-specific behavior for each state. That is, define an interface (state) for performing state-specific behavior, and define classes that implement the interface for each state. 
* A class delegates state-specific behavior to its current state object instead of implementing state-specific behavior directly.

This makes a class independent of how state-specific behavior is implemented. New states can be added by defining new state classes. A class can change its behavior at run-time by changing its current state object.

### Examples
An example for a state machine you find under 
[packagedelivery](packagedelivery).


### Links
* https://en.wikipedia.org/wiki/State_pattern
* https://en.wikipedia.org/wiki/Behavioral_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://www.baeldung.com/java-state-design-pattern
