package samples.solid.singleresponsibility;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import samples.solid.singleresponsibility.forms.AreaCalculator;
import samples.solid.singleresponsibility.forms.AreaCalulatorNotSolid;
import samples.solid.singleresponsibility.forms.AreaPrinter;
import samples.solid.singleresponsibility.forms.Circle;
import samples.solid.singleresponsibility.forms.Forms;
import samples.solid.singleresponsibility.forms.Square;

public class FormsTest {
  private static Forms[] FORMS = new Forms[] {new Circle(1), new Square(5), new Square(2)};

  @Test
  public void AreaCalculatorAreaTest() {
    assertEquals(32.1415926535898, new AreaCalculator(FORMS).area(), 0.01);
  }

  @Test
  public void AreaCalculatorToStringTest() {
    assertEquals("Circle(1.0),Square(5.0),Square(2.0)", new AreaCalculator(FORMS).toString());
  }

  @Test
  public void AreaCalculatorNotSolidToStringTest() {
    new AreaCalulatorNotSolid(FORMS).printOut();
  }

  @Test
  public void AreaPrinterTest() {
    new AreaPrinter(new AreaCalculator(FORMS)).printOut();
  }

  @Test
  public void SquareAreaTest() {
    assertEquals(4.0, new Square(2).area(), 0.0);
  }

  @Test
  public void CircleAreaTest() {
    assertEquals(6.283185307179586, new Circle(2).area(), 0.001);
  }
}
