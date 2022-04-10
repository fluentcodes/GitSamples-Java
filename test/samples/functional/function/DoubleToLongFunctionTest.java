package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class DoubleToLongFunctionTest {

  static final DoubleToLongFunction FUNCTION = d -> ((Double)d).longValue() + 10;

  @Test
  public void apply() {
    assertEquals(13, FUNCTION.applyAsLong(3.1));
  }

  /**
   * Working on int stream need mapToObject
   * https://stackoverflow.com/questions/29028980/why-cant-i-map-integers-to-strings-when-streaming-from-an-array
   */
  @Test
  public void doubleStream() {
    DoubleStream doubleStream = Arrays.stream(new double[]{1.1, 2.999, 3.2});
    Stream<Long> longStream = doubleStream.mapToObj(FUNCTION::applyAsLong);
    Stream<String> stringStream = longStream.map(d->d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("11,12,13", csv);
  }

  @Test
  public void listDoubleStream() {
    Stream<Double> doubleStream = Arrays.asList(1.1, 2.2, 3.7).stream();
    Stream<Long> longStream = doubleStream.map(FUNCTION::applyAsLong);
    Stream<String> stringStream = longStream.map(d->d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("11,12,13", csv);
  }
}
