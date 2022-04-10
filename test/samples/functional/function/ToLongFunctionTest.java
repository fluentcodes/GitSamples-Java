package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.ToDoubleFunction;
import java.util.function.ToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;
import static samples.stream.stream.MatchTest.NAMES;

public class ToLongFunctionTest {

  static final ToLongFunction<String> FUNCTION = s -> Long.valueOf(s.length());
  @Test
  public void string() {
    assertEquals(10, FUNCTION.applyAsLong("GitSamples"));
  }

  @Test
  public void list() {
    Stream<String> stream = Arrays.asList("Tim", "Tom", "Micha")
        .stream();
    long[] values = stream
        .mapToLong(FUNCTION::applyAsLong)
        .toArray();
    assertEquals(3L, values[1]);
  }

  @Test
  public void stringWithInnerClass() {
    ToLongFunction<String> innerClassImplementation = new ToLongFunction<String>() {
      @Override
      public long applyAsLong(String value) {
        return value.length();
      }
    };
    assertEquals(10L, innerClassImplementation.applyAsLong("GitSamples"));
  }

}
