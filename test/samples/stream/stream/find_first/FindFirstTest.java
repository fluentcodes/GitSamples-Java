package samples.stream.stream.find_first;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.Arrays;
import java.util.NoSuchElementException;
import java.util.Optional;
import java.util.UUID;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

public class FindFirstTest {

  @Test
  public void test() {
    Stream<String> stream = Arrays.asList("A", "B").stream();
    Optional<String> value = stream
        .findFirst();
    assertEquals("A", value.get());
  }

  @Test
  public void filterLengthGt2(){
    Stream<String> stream = Arrays.asList("1", "2.", "third", "4th", "more...").stream();

    Optional<String> value = stream
        .filter(s -> s.length() > 2)
        .findFirst();
    assertEquals("third", value.get());
  }

  @Test
  public void ifPresent() {
    Stream<String> stream = Arrays.asList("1", "2.", "third", "4th", "more...").stream();
    stream
        .filter(s -> s.length() > 2)
        .findFirst()
        .ifPresent(System.out::println);
  }

  @Test
  public void getFound() throws Exception {
    Stream<String> stream = Arrays.asList("1", "2.", "third", "4th", "more...").stream();
    String value = stream
        .filter(s -> s.length() > 2)
        .findFirst()
        .get();
    assertEquals("third", value);
  }

  @Test(expected = NoSuchElementException.class)
  public void getEmpty() throws Exception {
    Stream<String> stream = Arrays.asList("1", "2.", "third", "4th", "more...").stream();
    String value = stream
        .filter(s -> s.length() > 20)
        .map(s -> "Long item: " + s)
        .findFirst()
        .get();
    assertNull(value);
  }

  @Test
  public void orElse() {
    Stream<String> stream = Arrays.asList("1", "2.", "third", "4th", "more...").stream();
    String value = stream
        .filter(s -> s.length() > 20)
        .map(s -> "Long item: " + s)
        .findFirst()
        .orElse("No such result");
    assertEquals("No such result", value);
  }

  @Test(expected = IllegalStateException.class)
  public void orElseThrow() {
    Stream<String> stream = Arrays.asList("1", "2.", "third", "4th", "more...").stream();
    String value = stream
        .filter(s -> s.length() > 20)
        .map(s -> "Long item: " + s)
        .findFirst()
        .orElseThrow(IllegalStateException::new);
  }


  @Test
  public void average() {

    System.out.println("All those primitive streams work just like regular object streams with the following differences: Primitive streams use specialized lambda expressions, e.g. IntFunction instead of Function or IntPredicate instead of Predicate. And primitive streams support the additional terminal aggregate operations sum() and average():");
    Arrays.stream(new int[] {1, 2, 3})
        .map(n -> 2 * n + 1)
        .average()
        .ifPresent(System.out::println);
  }

  @Test
  public void UUIDContaining() throws Exception {
    final int maxTests = 200000;
    String value = IntStream.range(0, maxTests)
        .mapToObj(i -> UUID.randomUUID().toString())
        .filter(s -> s.contains("abc"))
        .findFirst()
        .orElse("No match");
    System.out.println(value);
  }
}
