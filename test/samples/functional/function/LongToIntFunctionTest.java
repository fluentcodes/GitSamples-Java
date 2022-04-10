package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.LongToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class LongToIntFunctionTest {

  static final LongToIntFunction FUNCTION = i -> ((Long) i).intValue() + 11;

  @Test
  public void apply() {
    double value = FUNCTION.applyAsInt(3L);
    assertEquals(14.0, value, 0.01);
  }

  @Test
  public void doubleStream() {
    LongStream longStream = Arrays.stream(new long[]{1L, 2L, 3L});
    IntStream intStream = longStream.mapToInt(FUNCTION::applyAsInt);
    int[] intArray = intStream
        .toArray();
    assertEquals(14, intArray[2]);
  }

  /**
   * Working on int stream need mapToObject
   * https://stackoverflow.com/questions/29028980/why-cant-i-map-integers-to-strings-when-streaming-from-an-array
   */
  @Test
  public void doubleStreamMapToObj() {
    LongStream stream = Arrays.stream(new long[]{1L, 2L, 3L});
    Stream<Integer> integerStream = stream.mapToObj(FUNCTION::applyAsInt);
    Stream<String> stringStream = integerStream.map(d -> d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("12,13,14", csv);
  }

  @Test
  public void listDoubleStream() {
    LongStream stream = Arrays.stream(new long[]{1L, 2L, 3L});
    Stream<Integer> integerStream = stream.mapToObj(FUNCTION::applyAsInt);
    Stream<String> stringStream = integerStream.map(d -> d.toString());
    String csv = stringStream
        .collect(Collectors.joining(","));
    assertEquals("12,13,14", csv);
  }
}
