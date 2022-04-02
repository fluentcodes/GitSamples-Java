## [GitSamples](/../../tree/master) - [State Pattern](/../../tree/java-design-pattern/test/samples/behavioural/state): Package Delivery Example

This example as a [Package](Package.java) containing a 
[PackageState](PackageState).

Each State knows the 
* next
* previous 

state class in the following order: 
* [OrderedState](OrderedState.java): Initial
* [DeliveredState](DeliveredState.java)
* [ReceivedState](ReceivedState.java)

### Tests
In the [StateTest](StateTest.java) there is a simple
chain:

    Package pkg = new Package();
    assertEquals(OrderedState.class, pkg.getState().getClass());

    pkg.nextState();
    assertEquals(DeliveredState.class, pkg.getState().getClass());

    pkg.nextState();
    assertEquals(ReceivedState.class, pkg.getState().getClass());

### Links
* https://www.baeldung.com/java-state-design-pattern
