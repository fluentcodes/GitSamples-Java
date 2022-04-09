package samples.functional.binary_operator;

import org.junit.Test;

import java.util.function.LongBinaryOperator;

import static org.junit.Assert.assertEquals;

public class LongBinaryOperatorTest {
  int x = 7;
  int y = 5;

  @Test
  public void add() {
    LongBinaryOperator operator =
        Long::sum;
    assertEquals(12,
        operator.applyAsLong(x, y));
  }

  @Test
  public void minus() {
    LongBinaryOperator operator =
        (a, b) -> a - b;
    assertEquals(2,
        operator.applyAsLong(x, y));
  }

  @Test
  public void multiplicate() {
    LongBinaryOperator operator =
        (a, b) -> a * b;
    assertEquals(35,
        operator.applyAsLong(x, y));
  }

  @Test
  public void div() {
    LongBinaryOperator operator =
        (a, b) -> a / b;
    assertEquals(Long.valueOf(1),
        compute(operator));
  }

  @Test
  public void test() {
    LongBinaryOperator operator =
        (a, b) -> a % b;
    assertEquals(Long.valueOf(2),
        compute(operator));
  }

  public Long compute(LongBinaryOperator operator) {
    return operator.applyAsLong(x, y);
  }

}