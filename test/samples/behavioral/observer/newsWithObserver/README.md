## [GitSamples](/../../tree/master) - [Command Pattern](/../../tree/java-design-pattern/test/samples/behavioural/observer): Observer Example

This example uses the java Observer classes implemented both by 
* [Agency](Agency.java): Subject
* [Channel](Channel.java): Observer

### Tests
In the [ObserverTest](ObserverTest.java) there 
will be checked if setting the **news** in
[Agency](Agency.java) will set the value in [Channel](Channel.java).

    observable.setNews("news");
    assertEquals(observer.getNews(), "news");

### Links
* https://www.baeldung.com/java-observer-pattern
