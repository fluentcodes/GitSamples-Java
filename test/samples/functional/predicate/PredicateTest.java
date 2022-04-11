package samples.functional.predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

public class PredicateTest {

  @Test
  public void testStream() throws Exception {
    final Predicate<String> more = s -> s.startsWith("more");

    Stream<String> stream = Arrays.asList("1", "2.", "third", "4th", "more...").stream();

    stream
        .filter(more)
        .forEach(System.out::println);
  }

  @Test
  public void and() throws Exception {
    final Predicate<String> lengthGt2 = s -> s.length() > 2;
    final Predicate<String> startWithMore = s -> s.startsWith("more");

    final Predicate<String> lengthAndNotMore = lengthGt2
        .and(
            startWithMore
                .negate()
        );

    Stream<String> stream = Arrays.asList("1", "2.", "third", "4th", "more...").stream();

    assertEquals("third,4th",
        stream
        .filter(lengthAndNotMore)
        .collect(Collectors.joining(","))
    );
  }

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
