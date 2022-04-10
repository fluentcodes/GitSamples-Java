package samples.functional.function_bi;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;

public class BiFunctionTest {

  @Test
  public void add() {
    BiFunction<Integer, Integer, Integer> addTwo = (a, b) -> a + b;
    assertEquals(Integer.valueOf(3), addTwo.apply(1, 2));
  }

  @Test
  public void addBiFunctionAsArgument() {
    assertEquals(Integer.valueOf(3), consumeAsArgument(1, 2, (a, b) -> a + b));
  }

  @Test
  public void multiplicateBiFunctionAsArgument() {
    assertEquals(Integer.valueOf(6), consumeAsArgument(2, 3, (a, b) -> a * b));
  }

  @Test
  public void divBiFunctionAsArgument() {
    assertEquals(Integer.valueOf(0), consumeAsArgument(2, 3, (a, b) -> a / b));
  }

  static Number consumeAsArgument(Integer a, Integer b, BiFunction<Integer, Integer, Number> consumer) {
    return consumer.apply(a, b);
  }


  BiFunction<List<Integer>, List<Integer>, Map<Integer, Integer>> createMap =
      (list1, list2) ->
      {
        if (list1.size() != list2.size()) {
          throw new RuntimeException(list1 + " different in size " + list2 );
        } else {
          Map<Integer,Integer> map = new HashMap<>();

          for (int i = 0; i < list1.size(); i++) {
            map.put(list1.get(i), list2.get(i));
          }
          return map;
        }
      };

  @Test
  public void listToMap() {
    assertEquals(Integer.valueOf(4),createMap.apply(
        Arrays.asList(1,2),
        Arrays.asList(3,4)
    ).get(2)
    );
  }
}