package samples.creational.factory;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import samples.solid.singleresponsibility.forms.Forms;

public class FormFactoryTest {
  @Test
  public void testSquare() {
    Forms square = new FormFactory().create("SQUARE");
    assertEquals(9.0, square.area(), 0.01);
  }
}
