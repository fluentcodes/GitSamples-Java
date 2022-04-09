package samples.functional.supplier;

import org.junit.Test;

import java.util.Random;
import java.util.function.LongSupplier;

import static org.junit.Assert.assertEquals;

public class LongSupplierTest {
  @Test
  public void supplier() {
    LongSupplier supplier = () -> new Random().nextLong();
    System.out.println(supplier.getAsLong());
  }

  @Test
  public void assertSupplier() {
    LongSupplier supplier = () -> 5L;
    assertEquals(5L, supplier.getAsLong());
  }
}