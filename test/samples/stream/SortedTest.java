package samples.stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class SortedTest {
  @Test
  public void integer() {
    Stream<Integer> stream = Arrays.asList(1, 2, 1).stream();
    Stream<Integer> sortedStream = stream.sorted();
    assertEquals(Arrays.asList(1, 1, 2), sortedStream.collect(Collectors.toList()));
  }

  @Test
  public void string() {
    Stream<String> stream = Arrays.asList("A", "B", "A").stream();
    Stream<String> sortedStream = stream.sorted();
    assertEquals(Arrays.asList("A", "A", "B"), sortedStream.collect(Collectors.toList()));
  }

  @Test(expected = NullPointerException.class)
  public void stringWithNull_Empty() {
    Stream<String> stream = Arrays.asList("A", null, "B").stream();
    Stream<String> sortedStream = stream.sorted();
    assertEquals(Arrays.asList(), sortedStream.collect(Collectors.toList()));
  }

  @Test(expected = IllegalStateException.class)
  public void stringStreamClosed() {
    Stream<String> stream = Arrays.asList("A", "B", "A").stream();
    stream.forEach(System.out::println);
    Stream<String> sortedStream = stream.sorted();
  }
}
