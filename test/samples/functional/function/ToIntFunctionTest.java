package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ToIntFunctionTest {

  static final ToIntFunction<String> FUNCTION = s -> s.length();

  @Test
  public void string() {
    assertEquals(10, FUNCTION.applyAsInt("GitSamples"));
  }

  @Test
  public void list() {
    Stream<String> stream = Arrays.asList("Tim", "Tom", "Micha")
        .stream();
    int[] values = stream
        .mapToInt(FUNCTION::applyAsInt)
        .toArray();
    assertEquals(3L, values[1]);
  }

  @Test
  public void stringWithInnerClass() {
    ToIntFunction<String> innerClassImplementation = new ToIntFunction<String>() {
      @Override
      public int applyAsInt(String value) {
        return value.length();
      }
    };
    assertEquals(10, innerClassImplementation.applyAsInt("GitSamples"));
  }

}
