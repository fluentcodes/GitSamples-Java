package samples.behavioral.mediator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LampTest {
  @Test
  public void test() {
    Power power = new Power();
    Lamp lamp = new Lamp(power);

    assertFalse(lamp.isOn());

    lamp.getButton().press();
    assertTrue(lamp.isOn());

    lamp.getButton().press();
    lamp.getButton().press();
    lamp.getButton().press();
  }
}
