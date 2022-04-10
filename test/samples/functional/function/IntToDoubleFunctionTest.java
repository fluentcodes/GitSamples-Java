package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.DoubleFunction;
import java.util.function.IntToDoubleFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class IntToDoubleFunctionTest {

  static final IntToDoubleFunction FUNCTION = i -> Double.valueOf(i)/3;

  @Test
  public void apply() {
    double value = FUNCTION.applyAsDouble(3);
    assertEquals(1.0, value, 0.1);
  }

  @Test
  public void doubleStream() {
    IntStream intStream = Arrays.stream(new int[]{1, 2, 3});
    DoubleStream doubleStream = intStream.mapToDouble(FUNCTION::applyAsDouble);
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
    IntStream stream = Arrays.stream(new int[]{1, 2, 3});
    Stream<Double> doubleStream = stream.mapToObj(FUNCTION::applyAsDouble);
    Stream<String> stringStream = doubleStream.map(d->d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("0.3333333333333333,0.6666666666666666,1.0", csv);
  }

  @Test
  public void listDoubleStream() {
    Stream<Integer> stream = Arrays.asList(1, 2, 3).stream();
    Stream<Double> doubleStream = stream.map(FUNCTION::applyAsDouble);
    Stream<String> stringStream = doubleStream.map(d->d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("0.3333333333333333,0.6666666666666666,1.0", csv);
  }
}
