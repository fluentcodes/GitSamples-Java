## [GitSamples](/../../tree/master) - [Creational](/../../tree/java-design-pattern/test/samples/creational): Factory Pattern

### Problems
* How can an object be created so that subclasses can redefine which class to instantiate?
* How can a class defer instantiation to subclasses?

### Solution
* Define a separate operation (factory method) for creating an object.
* Create an object by calling a factory method.

### Examples
In [FormFactory](FormFactory.java) we have a create method 
reusing [Forms](../../solid/singleresponsibility/forms/Forms.java). 

The create method just returns an concrete object depending on a parameter.

    switch (formName) {
      case _SQUARE: return new Square(3);
      case _CIRCLE: return new Circle(3);
      default: return new Square(2);
    }

### Links
* https://en.wikipedia.org/wiki/Factory_method_pattern
* https://en.wikipedia.org/wiki/Factory_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://en.wikipedia.org/wiki/Creational_pattern
* https://www.tutorialspoint.com/design_pattern/factory_pattern.htm
* https://www.javatpoint.com/factory-method-design-pattern
* https://refactoring.guru/design-patterns/factory-method/java/example
