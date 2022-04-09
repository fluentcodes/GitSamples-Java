package samples.stream.long_stream;

import org.junit.Ignore;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class LongStreamTest {

  @Test
  public void collect() {
    List<Long> intList = LongStream.of(1, 2, 3)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Long.valueOf(1), intList.get(0));
  }

  @Test
  public void range() {
    List<Long> intList = LongStream.range(1, 3)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Long.valueOf(2), intList.get(1));
  }

  @Test
  public void mapToDouble() {
    List<Double> list = LongStream.range(1, 3)
        .mapToDouble(i -> i)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Double.valueOf(2.0), list.get(1));
  }


  @Test
  public void mapToInt() {
    List<Integer> list = LongStream.range(1, 3)
        .mapToInt(i -> (int) i)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Integer.valueOf(2), list.get(1));
  }

  @Test
  public void allMatch() {
    assertFalse(LongStream.range(1, 3)
        .allMatch(i -> i % 2 == 0));
  }

  @Test
  public void anyMatch() {
    assertTrue(LongStream.range(1, 3)
        .anyMatch(i -> i % 2 == 0));
  }

  @Test
  @Ignore
  public void max() {
    assertEquals(3, LongStream.range(1, 3)
        .max()
        .getAsLong());
  }

  @Test
  public void min() {
    assertEquals(1, LongStream.range(1, 3)
        .min()
        .getAsLong());
  }

  // TODO should be 6?

  @Test
  @Ignore
  public void reduceMult() {
    assertEquals(6, LongStream.range(1, 3)
        .reduce(1, (a, b) -> a + b));
  }
}
