package samples.stream.int_stream;

import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static samples.TestObjectProvider.LIST_INTEGER;

public class IntStreamTest {

  @Test
  public void intList() {
    List<Integer> intList = IntStream.of(1,2,3)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Integer.valueOf(1), intList.get(0));
  }

  @Test
  public void range() {
    List<Integer> intList = IntStream.range(1,3)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Integer.valueOf(2), intList.get(1));
  }

  @Test
  public void mapToDouble() {
    List<Double> list = IntStream.range(1,3)
        .mapToDouble(i->i)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Double.valueOf(2.0), list.get(1));
  }


  @Test
  public void mapToLong() {
    List<Long> list = IntStream.range(1,3)
        .mapToLong(i->i)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Long.valueOf(2), list.get(1));
  }

  @Test
  public void allMatch() {
    assertFalse(IntStream.range(1,3)
        .allMatch(i -> i % 2 == 0));
  }

  @Test
  public void anyMatch() {
    assertTrue(IntStream.range(1,3)
        .anyMatch(i -> i % 2 == 0));
  }

  @Test
  public void max() {
    assertEquals(3, IntStream.range(1,3)
        .max()
        .getAsInt());
  }

  @Test
  public void min() {
    assertEquals(1, IntStream.range(1,3)
        .min()
        .getAsInt());
  }

  @Test
  public void reduceMult() {
    assertEquals(6, IntStream.range(1,3)
        .reduce(1, (a,b) -> a + b));
  }
}
