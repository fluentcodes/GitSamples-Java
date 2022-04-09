package samples.functional.binary_operator;

import org.junit.Test;

import java.util.function.IntBinaryOperator;

import static org.junit.Assert.assertEquals;

public class IntBinaryOperatorTest {
  int x = 7;
  int y = 5;

  @Test
  public void add() {
    IntBinaryOperator operator =
        Integer::sum;
    assertEquals(12,
        operator.applyAsInt(x, y));
  }

  @Test
  public void minus() {
    IntBinaryOperator operator =
        (a, b) -> a - b;
    assertEquals(2,
        operator.applyAsInt(x, y));
  }

  @Test
  public void multiplicate() {
    IntBinaryOperator operator =
        (a, b) -> a * b;
    assertEquals(35,
        operator.applyAsInt(x, y));
  }

  @Test
  public void div() {
    IntBinaryOperator operator =
        (a, b) -> a / b;
    assertEquals(Integer.valueOf(1),
        compute(operator));
  }

  @Test
  public void test() {
    IntBinaryOperator operator =
        (a, b) -> a % b;
    assertEquals(Integer.valueOf(2),
        compute(operator));
  }

  public Integer compute(IntBinaryOperator operator) {
    return operator.applyAsInt(x, y);
  }

}