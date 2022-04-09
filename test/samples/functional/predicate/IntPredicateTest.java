package samples.functional.predicate;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Arrays;
import java.util.List;
import java.util.function.IntPredicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import org.junit.Test;

public class IntPredicateTest {
  @Test
  public void test() {
    IntPredicate predicate = n -> n > 5;
    assertFalse(predicate.test(3));
    assertTrue(predicate.test(11));
    List<Integer> filtered = Arrays
        .stream(new Integer[] {1, 12, 3})
        .mapToInt(x->x)
        .filter(predicate)
        .boxed()
        .collect(Collectors.toList());

    assertEquals(Arrays.asList(12), filtered);
  }

  @Test
  public void isOdd() {
    IntPredicate isOdd = argument -> argument % 2 == 1;
    assertTrue( isOdd.test(9) );  //true
    assertFalse( isOdd.test(10) ); //false
    // stream
    IntStream stream = IntStream.range(1, 10);
    List<Integer> oddNumbers = stream
        .filter(isOdd)
        .boxed()
        .collect(Collectors.toList());
    System.out.println(oddNumbers);
  }
}
