package samples.functional.binary_operator;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;

import static org.junit.Assert.assertEquals;

public class BinaryOperatorTest {
  static List<Integer> INT_LIST = Arrays.asList(1, 2, 3);
  @Test
  public void add() {
    BiFunction<Integer, Integer, Integer> addTwo = (a, b) -> a + b;
    BinaryOperator<Integer> addTwoBinary = (a, b) -> a + b;
    assertEquals(Integer.valueOf(3), addTwo.apply(1, 2));
    assertEquals(Integer.valueOf(3), addTwoBinary.apply(1, 2));
  }

  @Test
  public void sum() {
    BinaryOperator<Integer> integerBinaryOperator = (a, b) -> a + b;
    assertEquals(Integer.valueOf(6),
          math(INT_LIST, 0, integerBinaryOperator));
    }

  @Test
  public void multiplicate() {
    BinaryOperator<Integer> integerBinaryOperator = (a, b) -> a * b;
    assertEquals(Integer.valueOf(6),
        math(INT_LIST, 1, integerBinaryOperator));
  }

  @Test
  public void integerSum() {
    BinaryOperator<Integer> integerBinaryOperator = Integer::sum;
    assertEquals(Integer.valueOf(6),
        math(INT_LIST, 0, integerBinaryOperator));
  }



  static <T> T math(List<T> list, T init, BinaryOperator<T> accumulator) {
    T result = init;
    for (T t : list) {
      result = accumulator.apply(result, t);
    }
    return result;
  }
}