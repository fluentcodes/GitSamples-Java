package samples.utilStream.numbers;

import static org.junit.Assert.assertEquals;
import static samples.TestObjectProvider.LIST_INTEGER;
import java.util.IntSummaryStatistics;
import org.junit.Test;

public class IntSummaryStatisticsTest {
  static final IntSummaryStatistics STATISTICS_INTEGER = LIST_INTEGER.stream()
      .mapToInt((x) -> x).summaryStatistics();

  @Test
  public void testCount() {
    assertEquals(9, STATISTICS_INTEGER.getCount());
  }

  @Test
  public void testMax() {
    assertEquals(19, STATISTICS_INTEGER.getMax());
  }

  @Test
  public void testMin() {
    assertEquals(1, STATISTICS_INTEGER.getMin());
  }

  @Test
  public void testSum() {
    assertEquals(85, STATISTICS_INTEGER.getSum());
  }

  @Test
  public void testAverage() {
    assertEquals(9.444444444444445, STATISTICS_INTEGER.getAverage(), 0.01);
  }
}
