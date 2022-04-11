package samples.stream.stream.peek;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class PeekTest {
  @Test
  public void test() {
    Stream<Integer> stream = Arrays.asList(1, 2, 1).stream();
    assertEquals(Arrays.asList(1, 2, 1), stream
        .peek(in->System.out.println("value: " + in))
        .collect(Collectors.toList()));
  }
}
