package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class LongFunctionTest {

  static final LongFunction<String> FUNCTION = i -> ((Long) i).toString();

  @Test
  public void string() {
    assertEquals("3", FUNCTION.apply(3L));
  }

  /**
   * Working on int stream need mapToObject
   * https://stackoverflow.com/questions/29028980/why-cant-i-map-integers-to-strings-when-streaming-from-an-array
   */
  @Test
  public void longStream() {
    LongStream stream = Arrays.stream(new long[]{1L, 2L, 3L});
    String csv = stream
        .mapToObj(FUNCTION::apply)
        //.map(FUNCTION::apply)  not working on intStream
        .collect(Collectors.joining(","));
    assertEquals("1,2,3", csv);
  }

  @Test
  public void listLongStream() {
    Stream<Long> stream = Arrays.asList(1L, 2L, 3L).stream();
    String csv = stream
        .map(FUNCTION::apply)
        .collect(Collectors.joining(","));
    assertEquals("1,2,3", csv);
  }
}
