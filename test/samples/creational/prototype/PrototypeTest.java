package samples.creational.prototype;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class PrototypeTest {
  @Test
  public void testPrototype1() throws CloneNotSupportedException {
    Prototype1 prototype1 = new Prototype1("1");
    Prototype1 clone = (Prototype1) prototype1.clone();
    assertEquals("1", clone.getValue());
  }
}
