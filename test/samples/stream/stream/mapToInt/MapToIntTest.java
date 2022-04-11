package samples.stream.stream.mapToInt;

import static org.junit.Assert.assertArrayEquals;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.Test;

public class MapToIntTest {
  @Test
  public void length() throws Exception {
    Stream<String> stream = Arrays.asList("A", "AB", "ABC").stream();
    final int[] lengthArray =
        stream
            .map(String::length)
            .mapToInt(x -> x)
            .toArray();
    assertArrayEquals(new int[]{1,2,3}, lengthArray);
  }
}
