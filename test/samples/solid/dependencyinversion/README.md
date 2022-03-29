## [GitSamples](/../../tree/master) - [SOLID](/../../tree/java-design-pattern/test/samples/solid): Dependency Inversion Principle
<cite>A. High-level modules should not depend on low level modules. Both should depend on abstractions.</cite>

<cite>B. Abstractions should not depend upon details. Details should depend upon abstractions</cite>
### Examples
To illustrate this we have simple classes. 

Within [SwitchWrong](SwitchWrong.java) we use the [Lamp](LampWrong.java) class directly. 

In [Switch](Switch.java) we use the [LampInterface](LampInterface.java) instead of [Lamp](Lamp.java). This implementation of
[Switch](Switch.java) can controll different implementations of the [LampInterface](LampInterface.java)



### Links
* https://de.wikipedia.org/wiki/Dependency-Inversion-Prinzip
* https://en.wikipedia.org/wiki/Dependency_inversion_principle
