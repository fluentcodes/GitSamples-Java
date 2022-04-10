package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.LongToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class LongToDoubleFunctionTest {

  static final LongToDoubleFunction FUNCTION = i -> Double.valueOf(i) / 3;

  @Test
  public void apply() {
    double value = FUNCTION.applyAsDouble(3L);
    assertEquals(1.0, value, 0.1);
  }

  @Test
  public void doubleStream() {
    LongStream longStream = Arrays.stream(new long[]{1L, 2L, 3L});
    DoubleStream doubleStream = longStream.mapToDouble(FUNCTION::applyAsDouble);
    double[] doubleArray = doubleStream
        .toArray();
    assertEquals(1.0, doubleArray[2], 0.01);
  }

  /**
   * Working on int stream need mapToObject
   * https://stackoverflow.com/questions/29028980/why-cant-i-map-integers-to-strings-when-streaming-from-an-array
   */
  @Test
  public void doubleStreamMapToObj() {
    LongStream longStream = Arrays.stream(new long[]{1L, 2L, 3L});
    Stream<Double> doubleStream = longStream.mapToObj(FUNCTION::applyAsDouble);
    Stream<String> stringStream = doubleStream.map(d -> d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("0.3333333333333333,0.6666666666666666,1.0", csv);
  }

  @Test
  public void listDoubleStream() {
    LongStream longStream = Arrays.stream(new long[]{1L, 2L, 3L});
    Stream<Double> doubleStream = longStream.mapToObj(FUNCTION::applyAsDouble);
    Stream<String> stringStream = doubleStream.map(d -> d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("0.3333333333333333,0.6666666666666666,1.0", csv);
  }
}
