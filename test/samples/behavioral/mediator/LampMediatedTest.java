package samples.behavioral.mediator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class LampMediatedTest {
  @Test
  public void test() {
    ButtonMediated button = new ButtonMediated();
    LampMediated fan = new LampMediated();
    Power power = new Power();

    Mediator mediator = new Mediator();
    mediator.setButton(button);
    mediator.setFan(fan);
    mediator.setPowerSupplier(power);

    assertFalse(fan.isOn());

    button.press();
    assertTrue(fan.isOn());

    button.press();
    assertFalse(fan.isOn());
  }
}
