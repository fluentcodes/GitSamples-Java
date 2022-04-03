package samples.utilStream.numbers;

import static org.junit.Assert.assertEquals;
import static samples.TestObjectProvider.LIST_INTEGER;

import org.junit.Test;

public class MapToIntTest {

  @Test
  public void testSum() {
    assertEquals(85,
        LIST_INTEGER.stream()
            .mapToInt(Integer::intValue)
            .sum());
  }
}
