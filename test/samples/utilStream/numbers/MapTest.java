package samples.utilStream.numbers;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntUnaryOperator;
import java.util.stream.Collectors;
import org.junit.Test;
import samples.utilStream.ForeachTest;

public class MapTest {
  @Test
  public void mapSquare() {
    List<Integer> numbers = Arrays.asList(3, 2, 2, 3, 7, 3, 5);
    List<Integer> squaresList = numbers.stream()
        .map(i -> i * i)
        .distinct()
        .collect(Collectors.toList());
    assertEquals(new Integer(9), squaresList.get(0));
  }

  /**
   * Mapping functional reference
   */
  @Test
  public void startCreatedOperator() {
    System.out.println("Use created unitary operator with factor 1000");
    final int  factor = 1000;
    IntUnaryOperator times1000 = x -> x *  factor ;
    Arrays.stream(new int[]{1, 2}).
        map(times1000).
        forEach(System.out::println);
    System.out.println("Use static class method with factor 100");
    Arrays.stream(new int[]{1, 2}).
        map(MapTest::multiplicate).
        forEach(System.out::println);
  }

  public static final int multiplicate ( int value) {
    return value*100;
  }

  @Test
  public void convertFromStringToInt() {
    System.out.println("Array stream with map to Integer");
    Arrays.stream(new String[] {"1", "2"})
        .map( Integer::new)
        .map(i->i+1)
        .forEach(System.out::println);
  }
}
