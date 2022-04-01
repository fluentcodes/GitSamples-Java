## [GitSamples](/../../tree/master) - [Creational](/../../tree/java-design-pattern/test/samples/creational): Builder Pattern
<cite>Builder pattern aims to “Separate the construction of a complex object from its representation so that the same construction process can create multiple different representations.”</cite>

### Problems
* How can a class (the same construction process) create different representations of a complex object? 
* How can a class that includes creating a complex object be simplified?

### Solution
* Encapsulate creating and assembling the parts of a complex object in a separate Builder object.
* A class delegates object creation to a Builder object instead of creating the objects directly.
* A class (the same construction process) can delegate to different Builder objects to create different representations of a complex object.

### Example
In [FinalBuilder](FinalBuilder.java) we have mutable values which creates the immutable [FinalClass](FinalClass.java). 
A test to use it is in [FinalTest](FinalTest.java). This is how I use it in projects, sometimes also with an innerclass builder as 
mentioned in "Effective Java".

Could not find an example or use case for [FinalDirector](FinalDirector.java). 
Actually it just set some default values.

### Links
* https://en.wikipedia.org/wiki/Builder_pattern
* https://en.wikipedia.org/wiki/Object-oriented_programming
* https://en.wikipedia.org/wiki/Creational_pattern
* https://de.wikipedia.org/wiki/Erbauer_(Entwurfsmuster)
* https://www.vogella.com/tutorials/DesignPatternBuilder/article.html
* https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/
* https://www.digicomp.ch/blog/2017/12/07/das-builder-pattern