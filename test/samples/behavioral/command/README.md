## [GitSamples](/../../tree/master) - [Behavioral](/../../tree/java-design-pattern/test/samples/behavioural): Command Pattern
<cite>An object is used to encapsulate all information needed to perform an action or trigger an event at a later time. This information includes the method name, the object that owns the method and values for the method parameters.</cite>

### Problems
* Coupling the invoker of a request to a particular request should be avoided. That is, hard-wired requests should be avoided.
* It should be possible to configure an object (that invokes a request) with a request.

Implementing (hard-wiring) a request directly into a class is inflexible because it couples the class to a particular request at compile-time, which makes it impossible to specify a request at run-time.

### Solution
* Define separate (command) objects that encapsulate a request.
* A class delegates a request to a command object instead of implementing a particular request directly.

This enables one to configure a class with a command object that is used to perform a request. The class is no longer coupled to a particular request and has no knowledge (is independent) of how the request is carried out.

### Examples
Just a modified example from https://www.baeldung.com/java-command-pattern in
[file](file).

### Links
* https://en.wikipedia.org/wiki/Command_pattern
* https://de.wikipedia.org/wiki/Kommando_(Entwurfsmuster)
* https://en.wikipedia.org/wiki/Behavioral_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://www.baeldung.com/java-command-pattern
