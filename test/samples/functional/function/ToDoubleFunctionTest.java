package samples.functional.function;

import org.junit.Test;

import java.util.function.ToDoubleFunction;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;

public class ToDoubleFunctionTest {
  @Test
  public void sin() {
    ToDoubleFunction<Integer> lamda = (x) -> Math.sin(x);
    assertEquals(0.9092974268256817, lamda.applyAsDouble(2), 0.01);
  }

  @Test
  public void list() {
    ToDoubleFunction<Long> lamda = (x) -> Math.cos(x);
    double[] values = LongStream.range(0, 10)
        .mapToDouble(lamda::applyAsDouble)
        .toArray();
    assertEquals(0.28366218546322625, values[5], 0.01);
  }

  @Test
  public void array() {
    ToDoubleFunction<Long> lamda = (x) -> Math.tan(x);
    double[] values = LongStream.range(0, 10)
        .mapToDouble(lamda::applyAsDouble)
        .toArray();
    assertEquals(-3.380515006246586, values[5], 0.01);
  }

  @Test
  public void apply() {
    ToDoubleFunction<String> strLength = s -> s.length();    // lambda expression
    assertEquals(10.0, strLength.applyAsDouble("GitSamples"), 0.1);
  }

  @Test
  public void stringWithInnerClass() {
    ToDoubleFunction<String> innerClassImplementation = new ToDoubleFunction<String>() {
      @Override
      public double applyAsDouble(String value) {
        return value.length();
      }
    };
    assertEquals(10.0, innerClassImplementation.applyAsDouble("GitSamples"), 0.1);
  }

}
