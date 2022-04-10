package samples.stream.int_stream;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.Test;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static samples.TestBasics.print;
import static samples.TestObjectProvider.LIST_INTEGER;

public class IntStreamTest {

  @Test
  public void printIntStreamOf() {
    IntStream stream = IntStream.of(0,2,13);
    stream.forEach(print::log);
  }

  @Test
  public void printInt() {
    IntStream stream = Arrays.stream(new int[]{0,2,13});
    stream.forEach(print::log);
  }

  @Test
  public void intList() {
    List<Integer> intList = IntStream.of(1,2,3)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Integer.valueOf(1), intList.get(0));
  }

  @Test
  public void range() {
    List<Integer> intList = IntStream.range(1,3)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Integer.valueOf(2), intList.get(1));
  }

  @Test
  public void testIntStreamRange() {
    System.out.println("IntStream example: ");
    IntStream.range(1, 4)
        .forEach(System.out::println);
    System.out.println("All those primitive streams work just like regular object streams with the following differences: Primitive streams use specialized lambda expressions, e.g. IntFunction instead of Function or IntPredicate instead of Predicate. And primitive streams support the additional terminal aggregate operations sum() and average():");
    Arrays.stream(new int[] {1, 2, 3})
        .map(n -> 2 * n + 1)
        .average()
        .ifPresent(System.out::println);
  }

  @Test
  public void testConvert() {
    IntStream.of(0,2,13).mapToDouble(Double::new).forEach(System.out::println);

    System.out.println("Sometimes it's useful to transform a regular object stream to a primitive stream or vice versa. For that purpose object streams support the special mapping operations mapToInt(), mapToLong() and mapToDouble:");
    Stream.of("a1", "a2", "a3")
        .map(s -> s.substring(1))
        .mapToInt(Integer::parseInt)
        .max()
        .ifPresent(System.out::println);


    System.out.println("Primitive streams can be transformed to object streams via mapToObj():");
    IntStream.range(1, 4)
        .mapToObj(i -> "a" + i)
        .forEach(System.out::println);

    System.out.println("Convert a double to int and then to String object:");
    Stream.of(1.0, 2.0, 3.0)
        .mapToInt(Double::intValue)
        .mapToObj(i -> "a" + i)
        .forEach(System.out::println);
  }

  @Test
  public void mapToDouble() {
    List<Double> list = IntStream.range(1,3)
        .mapToDouble(i->i)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Double.valueOf(2.0), list.get(1));
  }


  @Test
  public void mapToLong() {
    List<Long> list = IntStream.range(1,3)
        .mapToLong(i->i)
        .boxed()
        .collect(Collectors.toList());
    assertEquals(Long.valueOf(2), list.get(1));
  }

  @Test
  public void allMatch() {
    assertFalse(IntStream.range(1,3)
        .allMatch(i -> i % 2 == 0));
  }

  @Test
  public void anyMatch() {
    assertTrue(IntStream.range(1,3)
        .anyMatch(i -> i % 2 == 0));
  }

  @Test
  public void max() {
    assertEquals(3, IntStream.range(1,3)
        .max()
        .getAsInt());
  }

  @Test
  public void min() {
    assertEquals(1, IntStream.range(1,3)
        .min()
        .getAsInt());
  }

  @Test
  public void reduceMult() {
    assertEquals(6, IntStream.range(1,3)
        .reduce(1, (a,b) -> a + b));
  }
}
