## [GitSamples](/../../tree/master) - [Behavioral](/../../tree/java-design-pattern/test/samples/behavioural): Template Method Pattern
<cite> The template method is a method in a superclass, usually an abstract superclass, and defines the skeleton of an operation in terms of a number of high-level steps.</cite>

This is a name to gather methods with a common implementation in sub classes into a abstract super class. 

Non public helper methods are called "hook methods". Depending on the programming language they could be abstract or empty
### Example
Here is a rather abstract example which should show how the different methods could be combined. 
We have and the two 
* [Sub1](Sub1.java)
* [Sub2](Sub2.java)

implementing the abstract methods  a [AbstractSuper](AbstractSuper.java) class. 

The difference between Sub1 and Sub2 beside different implementation is that [Sub2](Sub2.java)
overwrites the hookConcreate method.

### Links
* https://en.wikipedia.org/wiki/Template_method_pattern
* https://en.wikipedia.org/wiki/Behavioral_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://de.wikipedia.org/wiki/Schablonenmethode
* https://www.codeproject.com/Articles/307452/common-use-of-Template-Design-pattern-Design-pat
