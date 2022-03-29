## [GitSamples](/../../tree/master) - [SOLID](/../../tree/java-design-pattern/test/samples/solid): Interface Segregation Principle
<cite>Clients should not be forced to depend upon interfaces that they do not use.</cite>

### Examples
In the examples we have a "wrong" example with mixing flat forms with speres having volume as method. 
* [DiceWrong](DiceWrong.java) and 
* [SquareWrong](SquareWrong.java) implementing
* [Forms3DWrong](Forms3DWrong.java) with the methods 
  * area
  * volume

A client program like [VolumeCalculator](VolumeCalculator.java) don't know 
that Square will throw an Exception. This is unexpected only from code perspective. 

How one could implement it different with interface segregation is in 
* [Dice](Dice.java)
* [Forms3D](Forms3D.java)


### Links
* https://en.wikipedia.org/wiki/Interface_segregation_principle
* https://de.wikipedia.org/wiki/Interface-Segregation-Prinzip