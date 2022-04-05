package samples.stream.numbers;

import static org.junit.Assert.assertEquals;
import static samples.TestObjectProvider.LIST_INTEGER;

import java.util.stream.Collectors;
import org.junit.Test;

public class CollectorsTest {

  @Test
  public void testSummingInt() {
    assertEquals(Integer.valueOf(85),
        LIST_INTEGER.stream()
        .collect(Collectors.summingInt(Integer::intValue)));
  }
}
