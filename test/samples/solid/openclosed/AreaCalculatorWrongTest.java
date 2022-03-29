package samples.solid.openclosed;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class AreaCalculatorWrongTest {
  private static Object[] FORMS = new Object[] {new CircleWrong(1), new SquareWrong(5), new SquareWrong(2)};

  @Test
  public void testGetArea() {
    assertEquals(32.1415926535898, new AreaCalculatorWrong(FORMS).area(), 0.01);
  }

  @Test(expected = RuntimeException.class)
  public void testGetAreaException() {
    new AreaCalculatorWrong(new Object[]{"TEST"}).area();
  }
}
