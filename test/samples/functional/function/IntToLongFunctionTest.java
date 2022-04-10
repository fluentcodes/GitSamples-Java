package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.IntToLongFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class IntToLongFunctionTest {

  static final IntToLongFunction FUNCTION = i -> Long.valueOf(i) + 1;

  @Test
  public void apply() {
    long value = FUNCTION.applyAsLong(3);
    assertEquals(4, value);
  }

  @Test
  public void longStream() {
    IntStream intStream = Arrays.stream(new int[]{1, 2, 3});
    LongStream longStream = intStream.mapToLong(FUNCTION::applyAsLong);
    long[] longArray = longStream
        .toArray();
    assertEquals(4L, longArray[2]);
  }

  /**
   * Working on int stream need mapToObject
   * https://stackoverflow.com/questions/29028980/why-cant-i-map-integers-to-strings-when-streaming-from-an-array
   */
  @Test
  public void intStream() {
    IntStream intStream = Arrays.stream(new int[]{1, 2, 3});
    Stream<Long> longStream = intStream.mapToObj(FUNCTION::applyAsLong);
    Stream<String> stringStream = longStream.map(d -> d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("2,3,4", csv);
  }

  @Test
  public void integerStream() {
    Stream<Integer> integerStream = Arrays.asList(1, 2, 3).stream();
    Stream<Long> doubleStream = integerStream.map(FUNCTION::applyAsLong);
    Stream<String> stringStream = doubleStream.map(d -> d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("2,3,4", csv);
  }
}
