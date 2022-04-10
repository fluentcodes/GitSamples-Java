package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.DoubleToIntFunction;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class DoubleToIntFunctionTest {

  static final DoubleToIntFunction FUNCTION = d -> ((Double)d).intValue() + 3;

  @Test
  public void apply() {
    assertEquals(6, FUNCTION.applyAsInt(3.1));
  }

  /**
   * Working on int stream need mapToObject
   * https://stackoverflow.com/questions/29028980/why-cant-i-map-integers-to-strings-when-streaming-from-an-array
   */
  @Test
  public void doubleStream() {
    DoubleStream doubleStream = Arrays.stream(new double[]{1.1, 2.999, 3.2});
    Stream<Integer> integerStream = doubleStream.mapToObj(FUNCTION::applyAsInt);
    Stream<String> stringStream = integerStream.map(d->d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("4,5,6", csv);
  }

  @Test
  public void listDoubleStream() {
    Stream<Double> doubleStream = Arrays.asList(1.1, 2.2, 3.7).stream();
    Stream<Integer> integerStream = doubleStream.map(FUNCTION::applyAsInt);
    Stream<String> stringStream = integerStream.map(d->d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("4,5,6", csv);
  }
}
