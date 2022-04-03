## [GitSamples](/../../tree/master) - [Structural](/../../tree/java-design-pattern/test/samples/structural): Decorator Pattern
<cite>Decorator Pattern describe how to solve recurring design problems and design flexible and reusable object-oriented software—that is, objects which are easier to implement, change, test, and reuse.</cite>

### What problems can it solve?

* Responsibilities should be added to (and removed from) an object dynamically at run-time.[4]
* A flexible alternative to subclassing for extending functionality should be provided.

When using subclassing, different subclasses extend a class in different ways. But an extension is bound to the class at compile-time and can't be changed at run-time.[citation needed]
### What solution does it describe?

Define Decorator objects that

* implement the interface of the extended (decorated) object (Component) transparently by forwarding all requests to it
* perform additional functionality before/after forwarding a request.

### Examples
As one can see in [DecoratorTest](DecoratorTest.java) one can 
create chains of Decorators in any combination via constructor. 

    public ThirdDecorator(DecoratedObject decoratedObject) {
        super(decoratedObject);
    }

The method describe 

    public void describe() {
        System.out.print("From Third Decorator - ");
        super.describe();
    }

will then subsequently call the describe methods in the chain. 

    new ThirdDecorator(
        new SecondDecorator(
            new FirstDecorator(
                new SecondDecorator(new DecoratedObject())
            )
        )
    ).describe();

The output will be 

    From Third Decorator - From Second Decorator - From First Decorator - From Second Decorator - DecoratedObject


### Links
* https://www.philipphauer.de/study/se/design-pattern/decorator.php
* https://refactoring.guru/design-patterns/decorator
* https://www.baeldung.com/java-decorator-pattern
* https://en.wikipedia.org/wiki/Decorator_pattern
* https://en.wikipedia.org/wiki/Structural_pattern
* https://en.wikipedia.org/wiki/Software_design_pattern
* https://de.wikipedia.org/wiki/Decorator
