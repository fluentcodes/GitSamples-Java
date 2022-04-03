## [GitSamples](/../../tree/master) - [Strategy Pattern](/../../tree/java-design-pattern/test/samples/behavioural/strategy): Discounter Example
There is an implementation of the classical strategy pattern with 
* [EasterDiscounter](EasterDiscounter.java) and
* [ChristmasDiscounter](ChristmasDiscounter.java)

and a common apply method provided by UnaryOperator<BigDecimal>.

A test in [DiscounterTest](DiscounterTest.java) show the usage:

    BigDecimal discountedValue = new EasterDiscounter()
        .apply(BigDecimal.valueOf(100));

    assertEquals(BigDecimal.valueOf(50.0), discountedValue);

### Using Lamdas
Another solution for the problem is using Lamdas as in [Discounter](Discounter.java). Here we implement static methods like 

    static Discounter easter() {
        return (amount) -> amount.multiply(BigDecimal.valueOf(0.5));
    }

This provide the apply method e.g. 

    Discounter.easter()
        .apply(BigDecimal.valueOf(100))

### Links
* https://www.baeldung.com/java-interpreter-pattern