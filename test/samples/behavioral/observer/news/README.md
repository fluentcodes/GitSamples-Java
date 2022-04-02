## [GitSamples](/../../tree/master) - [Command Pattern](/../../tree/java-design-pattern/test/samples/behavioural/observer): ObserverInterface Example

This example uses a self defined [ObserverInterface](ObserverInterface.java) used by
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
