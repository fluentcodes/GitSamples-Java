package samples.function.predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import org.junit.Test;

public class PredicateTest {
  @Test
  public void testInt() {
    Predicate<Integer> predicate = n -> n > 5;

    assertFalse(predicate.test(3));
    assertTrue(predicate.test(11));

    List<Integer> filtered = Arrays
        .stream(new Integer[] {1, 12, 3})
        .filter(predicate)
        .collect(Collectors.toList());

    assertEquals(Arrays.asList(12), filtered);
  }
}
