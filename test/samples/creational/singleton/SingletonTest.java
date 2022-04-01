package samples.creational.singleton;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class SingletonTest {
  @Test
  public void testEmpty() {
    Singleton singleton = Singleton.getInstance();
    assertEquals(0, singleton.getValue());
    singleton.setValue(1);
  }

  // Global valid, only works if order is ok.
  @Test
  public void testOther() {
    Singleton singleton = Singleton.getInstance();
    assertEquals(1, singleton.getValue());
  }
}
