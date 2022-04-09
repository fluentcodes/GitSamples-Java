package samples.functional.binary_operator;

import org.junit.Test;

import java.util.function.DoubleBinaryOperator;

import static org.junit.Assert.assertEquals;

public class DoubleBinaryOperatorTest {
  double x = 7.654;
  double y = 5.567;

  @Test
  public void add() {
    DoubleBinaryOperator doubleBinaryOperator =
        Double::sum;
    assertEquals(13.221,
        doubleBinaryOperator.applyAsDouble(x, y),
        0.01);
  }

  @Test
  public void minus() {
    DoubleBinaryOperator doubleBinaryOperator =
        (a, b) -> a - b;
    assertEquals(2.0869999999999997,
        doubleBinaryOperator.applyAsDouble(x, y),
        0.01);
  }

  @Test
  public void multiplicate() {
    DoubleBinaryOperator doubleBinaryOperator =
        (a, b) -> a * b;
    assertEquals(42.609818000000004,
        doubleBinaryOperator.applyAsDouble(x, y),
        0.01);
  }

  @Test
  public void div() {
    DoubleBinaryOperator doubleBinaryOperator =
        (a, b) -> a / b;
    assertEquals(1.3748877312735763,
        compute(doubleBinaryOperator),
        0.01);
  }

  @Test
  public void test() {
    DoubleBinaryOperator doubleBinaryOperator =
        (a, b) -> a % b;
    assertEquals(2.0869999999999997,
        compute(doubleBinaryOperator),
        0.01);
  }

  public Double compute(DoubleBinaryOperator operator) {
    return operator.applyAsDouble(x, y);
  }

}