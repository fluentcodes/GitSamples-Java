package samples.functional.supplier;

import org.junit.Test;

import java.util.function.DoubleSupplier;

import static org.junit.Assert.assertEquals;

public class DouleSupplierTest {
  @Test
  public void supplier() {
    DoubleSupplier supplier = () -> Math.random();
    System.out.println(supplier.getAsDouble());
  }

  @Test
  public void assertSupplier() {
    DoubleSupplier supplier = () -> 5.0;
    assertEquals(5.0, supplier.getAsDouble(),0.01);
  }
}