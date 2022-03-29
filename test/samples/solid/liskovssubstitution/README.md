## [GitSamples](/../../tree/master) - [SOLID](/../../tree/java-design-pattern/test/samples/solid): Liskov's Substitution Principle
<cite>Let q ( x ) be a property provable about objects x of type T . Then q ( y ) should be true for objects y of type S where S is a subtype of T .</cite>
### Examples
Here the class [Line](Line.java) throws an Exception when the getArea method is called as 
a an implementation of [Forms](../singleresponsibility/forms/Forms.java).

So when using the [AreaCalculator](../singleresponsibility/forms/AreaCalculator.java) in
[LineTest](LineTest.java) an Exception occured determine the area. 

### Links
* https://en.wikipedia.org/wiki/Liskov_substitution_principle
* https://de.wikipedia.org/wiki/Liskovsches_Substitutionsprinzip
* https://www.digitalocean.com/community/conceptual_articles/s-o-l-i-d-the-first-five-principles-of-object-oriented-design-de#open-closed-prinzip
* https://medium.com/hackernoon/liskov-substitution-principle-a982551d584a
* https://www.baeldung.com/java-liskov-substitution-principle