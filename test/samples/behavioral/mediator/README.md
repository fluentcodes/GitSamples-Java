## [GitSamples](/../../tree/master) - [Behavioral](/../../tree/java-design-pattern/test/samples/behavioural): Mediator Pattern
<cite>the mediator pattern defines an object that encapsulates how a set of objects interact. This pattern is considered to be a behavioral pattern due to the way it can alter the program's running behavior.</cite>

### Problems
* Tight coupling between a set of interacting objects should be avoided.
* It should be possible to change the interaction between a set of objects independently.

Defining a set of interacting objects by accessing and updating each other directly is inflexible because it tightly couples the objects to each other and makes it impossible to change the interaction independently from (without having to change) the objects. And it stops the objects from being reusable and makes them hard to test.

Tightly coupled objects are hard to implement, change, test, and reuse because they refer to and know about many different objects.

### Solution
* Define a separate (mediator) object that encapsulates the interaction between a set of objects.
* Objects delegate their interaction to a mediator object instead of interacting with each other directly.

The objects interact with each other indirectly through a mediator object that controls and coordinates the interaction.

This makes the objects loosely coupled. They only refer to and know about their mediator object and have no explicit knowledge of each other.

### Examples
We have to examples, one not mediated and one mediated
#### Lamp 
Here we have the classes
* [Lamp](Lamp.java)
* [Button](Button.java) depending on [Lamp](Lamp.java) state
* [Power](Power.java)

with [LampTest](LampTest.java)

#### Lamp Mediated
Here we have the classes
* [Mediator](Mediator.java)
* [LampMediated](LampMediated.java) 
* [ButtonMediated](ButtonMediated.java)
* [Power](Power.java)

with [LampMediatedTest](LampMediatedTest.java)

### Links
* https://en.wikipedia.org/wiki/Mediator_pattern
* https://en.wikipedia.org/wiki/Behavioral_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://de.wikipedia.org/wiki/Vermittler_(Entwurfsmuster): only description, no examples
* https://www.baeldung.com/java-mediator-pattern