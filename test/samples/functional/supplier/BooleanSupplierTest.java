package samples.functional.supplier;

import org.junit.Test;

import java.util.Random;
import java.util.function.BooleanSupplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class BooleanSupplierTest {
    @Test
    public void supplier() {
        BooleanSupplier supplier = () -> new Random().nextInt(10)>5;
        System.out.println(supplier.getAsBoolean());
    }

    @Test
    public void assertSupplier() {
        BooleanSupplier supplier = () -> true;
        assertTrue(supplier.getAsBoolean());
    }
}