package samples.functional.supplier;

import org.junit.Test;

import java.util.Random;
import java.util.function.IntSupplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class IntSupplierTest {
    @Test
    public void supplier() {
        IntSupplier supplier = () -> new Random().nextInt(10);
        System.out.println(supplier.getAsInt());
    }

    @Test
    public void assertSupplier() {
        IntSupplier supplier = () -> 5;
        assertEquals(5, supplier.getAsInt());
    }
}