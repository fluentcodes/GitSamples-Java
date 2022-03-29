package samples.solid.liskovssubstitution;

import org.junit.Test;
import samples.solid.singleresponsibility.forms.AreaCalculator;
import samples.solid.singleresponsibility.forms.Forms;
import samples.solid.singleresponsibility.forms.Square;

public class LineTest {
  private static Forms[] FORMS = new Forms[] {new Square(1), new Line(5)};

  @Test(expected = RuntimeException.class)
  public void AreaCalculatorAreaTest() {
    new AreaCalculator(FORMS).area();
  }
}
