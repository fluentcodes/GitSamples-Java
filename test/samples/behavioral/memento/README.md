## [GitSamples](/../../tree/master) - [Behavioral](/../../tree/java-design-pattern/test/samples/behavioural): Memento Pattern
<cite>The memento pattern provides the ability to restore an object to its previous state (undo via rollback).</cite>

The memento pattern is implemented with three objects: 
* Originator: Some object that has an internal state.
* Caretaker:  Do something to the originator, but wants to be able to undo the change
* Memento. The caretaker first asks the originator for a memento object. 


### Problems
* The internal state of an object should be saved externally so that the object can be restored to this state later.
* The object's encapsulation must not be violated.

The problem is that a well designed object is encapsulated so that its representation (data structure) is hidden inside the object and can't be accessed from outside the object.
### Solution
Make an object (originator) itself responsible for

* saving its internal state to a (memento) object and
* restoring to a previous state from a (memento) object.

### Examples
There is an example a memento pattern with [textr](text).

### Links
* https://en.wikipedia.org/wiki/Memento_pattern
* https://en.wikipedia.org/wiki/Behavioral_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://www.baeldung.com/java-memento-design-pattern