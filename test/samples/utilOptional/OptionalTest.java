package samples.utilOptional;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Supplier;
import org.junit.Test;

/**
 * Created by Werner on 16.07.2016.
 * Originated from http://www.tutorialspoint.com/java8/java8_optional_class.htm
 * Optional is a container object which is used to contain not-null objects. Optional object is used to represent null with absent value.
 * This class has various utility methods to facilitate code to handle values as ‘available’ or ‘not available’ instead of checking null values.
 */
public class OptionalTest {
    @Test
    public void getInteger() {
        Integer value = Integer.valueOf(2);
        Optional<Integer> optional = Optional.of(value);
        assertTrue(optional.isPresent());
        assertEquals(value, optional.get());
    }

    @Test
    public void getString() {
        Optional<String> optional = Optional.of("hello");
        assertTrue(optional.isPresent());
        assertEquals(Optional.of("hello"), optional);
        assertEquals("hello", optional.get());
    }

    @Test
    public void ifPresentConsumer() {
        Optional<String> optional = Optional.of("hello");
        Consumer<String> consumer = string -> System.out.println("Consumed: " + string);
        optional.ifPresent(consumer); // print out "Consumed: hello"
    }

    @Test
    public void orElseSupplierHello() {
        Optional<String> optional = Optional.of("hello");
        Supplier<String> supplier = () -> "From supplier";
        assertEquals("hello", optional.orElseGet(supplier));
    }

    @Test
    public void orElseSupplierEmpty() {
        Optional<String> optional = Optional.empty();
        Supplier<String> supplier = () -> "From supplier";
        assertEquals("From supplier", optional.orElseGet(supplier));
    }

    @Test(expected = NoSuchElementException.class)
    public void empty() {
        Optional<String> optional = Optional.empty();
        assertFalse(optional.isPresent());
        optional.get();
    }

    @Test
    public void ofNullableInteger() {
        Optional<Integer> optionalNull = Optional.ofNullable(null);
        assertFalse(optionalNull.isPresent());
        assertNull(optionalNull.get()); //(Integer)optionalNull.get();
    }

    @Test
    public void orElseNull() {
        Optional<Integer> optionalNull = Optional.ofNullable(null);
        assertFalse(optionalNull.isPresent());
        assertEquals(Integer.valueOf(0), optionalNull.orElse(new Integer(0))); //(Integer)optionalNull.get();
    }

    @Test
    public void orElseNotNull() {
        Optional<Integer> optional = Optional.of(new Integer(1));
        assertFalse(optional.isPresent());
        assertEquals(Integer.valueOf(2), optional.orElse(new Integer(0))); //(Integer)optionalNull.get();
    }

    @Test
    public void sum() {
        Optional<Integer> optionalA = Optional.of(new Integer(1));
        Optional<Integer> optionalB = Optional.of(new Integer(2));
        assertEquals(3, optionalA.get() + optionalB.get());
    }

    @Test(expected = NoSuchElementException.class)
    public void sumNull() {
        Integer value = null;
        Optional<Integer> optionalA = Optional.ofNullable(value);
        Optional<Integer> optionalB = Optional.of(new Integer(2));
        Integer sum = optionalA.get() + optionalB.get();
    }

    @Test
    public void sumNullOrElse() {
        Integer value = null;
        Optional<Integer> optionalA = Optional.ofNullable(value);
        Optional<Integer> optionalB = Optional.of(new Integer(2));
        assertEquals(3, optionalA.orElse(new Integer(1)) + optionalB.get());
    }


}
