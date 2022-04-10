package samples.stream.double_stream;

import java.util.Arrays;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class DoubleStreamTest {

  @Test
  public void printDoubleStreamOf() {
    DoubleStream stream = DoubleStream.of(0.1,2.2,13.3);
    stream.forEach(print::log);
  }

  @Test
  public void printDouble() {
    Arrays.stream(new double[]{0.1,2.2,13.3})
        .forEach(print::log);
  }

  DoubleStream create() {
    return DoubleStream
        .iterate(1, d -> d + 0.5)
        .limit(5);
  }

  @Test
  public void collect() {
    List<Double> intList = DoubleStream.of(1.0, 2.0, 3.0)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Double.valueOf(1), intList.get(0));
  }

  @Test
  public void range() {
    List<Double> intList = create()
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Double.valueOf(1.5), intList.get(1));
  }

  @Test
  public void mapToLong() {
    List<Long> list = create()
        .mapToLong(i -> (long) i)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Long.valueOf(1), list.get(1));
  }


  @Test
  public void mapToInt() {
    List<Integer> list = create()
        .mapToInt(i -> (int) i)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Integer.valueOf(1), list.get(1));
  }

  @Test
  public void allMatch() {
    assertFalse(create()
        .allMatch(i -> i % 2 == 0));
  }

  @Test
  public void anyMatch() {
    assertTrue(create()
        .anyMatch(i -> i % 2 == 0));
  }

  @Test
  public void max() {
    assertEquals(Double.valueOf(3.0), create()
        .max()
        .getAsDouble(), 0.01);
  }

  @Test
  public void min() {
    assertEquals(Double.valueOf(1.0), create()
        .min()
        .getAsDouble(), 0.01);
  }

  // TODO should be 6?

  @Test
  public void reduceMult() {
    assertEquals(new Double(11.0), create()
        .reduce(1, (a, b) -> a + b), 0.01);
  }
}
