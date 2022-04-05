package samples.stream.numbers;

import static org.junit.Assert.assertEquals;
import static samples.TestObjectProvider.LIST_INTEGER;

import org.junit.Test;

public class ReduceTest {

  @Test
  public void testLambda() {
    assertEquals(Integer.valueOf(85),
        LIST_INTEGER.stream()
        .reduce(0, (a, b) -> a + b));
  }

  @Test
  public void testSum() {
    assertEquals(Integer.valueOf(85),
        LIST_INTEGER.stream()
            .reduce(0, Integer::sum));
  }

  @Test
  public void testAdd() {
    assertEquals(Integer.valueOf(85),
        LIST_INTEGER.stream()
            .reduce(0, ReduceTest::add));
  }

  public static int add(int a, int b) {
    return a + b;
  }

}
