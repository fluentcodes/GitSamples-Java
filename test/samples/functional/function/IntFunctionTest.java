package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.IntFunction;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class IntFunctionTest {

  static final IntFunction<String> FUNCTION = i -> ((Integer)i).toString();

  @Test
  public void string() {
    assertEquals("3", FUNCTION.apply(3));
  }

  /**
   * Working on int stream need mapToObject
   * https://stackoverflow.com/questions/29028980/why-cant-i-map-integers-to-strings-when-streaming-from-an-array
   */
  @Test
  public void intStream() {
    IntStream stream = Arrays.stream(new int[]{1,2,3});
    String csv = stream
        .mapToObj(FUNCTION::apply)
        //.map(FUNCTION::apply)  not working on intStream
        .collect(Collectors.joining(","));
    assertEquals("1,2,3", csv);
  }

  @Test
  public void intStreamBoxed() {
    IntStream stream = Arrays.stream(new int[]{1,2,3});
    String csv = stream
        .boxed()
        .map(FUNCTION::apply) // works with Boxed
        .collect(Collectors.joining(","));
    assertEquals("1,2,3", csv);
  }

  @Test
  public void integerStream() {
    Stream<Integer> stream = Arrays.asList(1,2,3).stream();
    String csv = stream
        .map(FUNCTION::apply)
        .collect(Collectors.joining(","));
    assertEquals("1,2,3", csv);
  }
}
