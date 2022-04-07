package samples.interfaces.default_method;

import org.junit.Test;

/**
 * Created by Werner on 16.07.2016.
 * Originated from http://www.tutorialspoint.com/java8/java8_default_methods.htm
 * Java 8 introduces a new concept of default method implementation in interfaces.
 * This capability is added for backward compatibility so that old interfaces can be used to leverage the lambda expression capability of Java 8.
 * For example, ‘List’ or ‘Collection’ interfaces do not have ‘forEach’ method declaration.
 * Thus, adding such method will simply break the collection framework implementations.
 * Java 8 introduces default method so that List/Collection interface can have a default implementation of forEach method, and the class implementing these interfaces need not implement the same.
 */
public class DefaultMethodTest {
    @Test
    public void test() {
        System.out.println("Start Experiments with Default Method:");
        Vehicle vehicle = new Car();
        vehicle.iAm();
        System.out.println("Finished Experiments with Default Method.");
    }
}
