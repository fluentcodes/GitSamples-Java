package samples.stream.stream.collect;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;

public class CollectToBooleanTest {
  public final static List<String> NAMES = Arrays.asList("Tim", "Tom", "Micha");
  final static Predicate<String> START_WITH_T = str -> str.toUpperCase().startsWith("T");

  @Test
  public void allMatch() {
    final boolean found = NAMES.stream()
        .allMatch(START_WITH_T);
    assertFalse(found);
  }

  @Test
  public void noneMatch() {
    final boolean found = NAMES.stream()
        .noneMatch(START_WITH_T);
    assertFalse(found);
  }

  @Test
  public void anyMatch() {
    final boolean found = NAMES.stream()
        .anyMatch(START_WITH_T);
    assertTrue(found);
  }

  @Test
  public void testMatch() throws Exception {
    List<String> list = Arrays.asList("1", "2.", "third", "4th", "more...");
    Assert.assertTrue(list.stream().allMatch(s -> s.length() > 0));
    Assert.assertFalse(list.stream().allMatch(s -> s.length() > 2));

    Assert.assertTrue(list.stream().anyMatch(s -> s.length() > 2));
    Assert.assertFalse(list.stream().anyMatch(s -> s.length() > 8));

    Assert.assertTrue(list.stream().noneMatch(s -> s.length() > 8));
    Assert.assertFalse(list.stream().noneMatch(s -> s.length() > 5));
  }

  @Test
  public void lazynessAnyMatch() {
    System.out.println("When a2 is reached, no operations will be executed any more");
    Stream<String> stream = Stream.of("d2", "a2", "a0", "b1", "b3", "c");
    stream
        .map(s -> {
          System.out.println("map: " + s);
          return s.toUpperCase();
        })
        .anyMatch(s -> {
          System.out.println("anyMatch: " + s);
          return s.startsWith("A");
        });
  }

}