package samples.stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class DistinctTest {
  @Test
  public void integer() {
    Stream<Integer> stream = Arrays.asList(1, 2, 1).stream();
    Stream<Integer> distinctStream = stream.distinct();
    assertEquals(Arrays.asList(1, 2), distinctStream.collect(Collectors.toList()));
  }

  @Test
  public void string() {
    Stream<String> stream = Arrays.asList("A", "B", "A").stream();
    Stream<String> distinctStream = stream.distinct();
    assertEquals(Arrays.asList("A", "B"), distinctStream.collect(Collectors.toList()));
  }
}
