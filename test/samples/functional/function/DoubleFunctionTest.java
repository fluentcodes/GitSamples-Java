package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.DoubleFunction;
import java.util.function.LongFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class DoubleFunctionTest {

  static final DoubleFunction<String> FUNCTION = d -> ((Double) d).toString();

  @Test
  public void string() {
    assertEquals("3.0", FUNCTION.apply(3.0));
  }

  /**
   * Working on int stream need mapToObject
   * https://stackoverflow.com/questions/29028980/why-cant-i-map-integers-to-strings-when-streaming-from-an-array
   */
  @Test
  public void doubleStream() {
    DoubleStream stream = Arrays.stream(new double[]{1.0, 2.0, 3.0});
    String csv = stream
        .mapToObj(FUNCTION::apply)
        //.map(FUNCTION::apply)  not working on intStream
        .collect(Collectors.joining(","));
    assertEquals("1.0,2.0,3.0", csv);
  }

  @Test
  public void listDoubleStream() {
    Stream<Double> stream = Arrays.asList(1.0, 2.0, 3.0).stream();
    String csv = stream
        .map(FUNCTION::apply)
        .collect(Collectors.joining(","));
    assertEquals("1.0,2.0,3.0", csv);
  }
}
