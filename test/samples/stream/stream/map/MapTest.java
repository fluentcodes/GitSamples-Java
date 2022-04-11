package samples.stream.stream.map;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class MapTest {
  @Test
  public void length() throws Exception {
    Stream<String> stream = Arrays.asList("A", "AB").stream();
    final List<Integer> lengthArray =
        stream
            .map(String::length)
            .collect(Collectors.toList());
    assertEquals(Arrays.asList(1,2), lengthArray);
  }
}
