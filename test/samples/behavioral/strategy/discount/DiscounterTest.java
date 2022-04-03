package samples.behavioral.strategy.discount;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import org.junit.Test;

public class DiscounterTest {
  @Test
  public void testStrategy() {
    BigDecimal discountedValue = new EasterDiscounter()
        .apply(BigDecimal.valueOf(100));

    assertEquals(BigDecimal.valueOf(50.0), discountedValue);
  }

  @Test
  public void testLamda() {
    assertEquals(BigDecimal.valueOf(50.0),
        Discounter.easter()
            .apply(BigDecimal.valueOf(100)));
  }
}
