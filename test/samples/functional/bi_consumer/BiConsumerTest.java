package samples.functional.bi_consumer;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.BiConsumer;

public class BiConsumerTest {

  @Test
  public void add() {
    BiConsumer<Integer, Integer> addTwo = (x, y) -> System.out.println("SUM IS: " + x + y);
    addTwo.accept(1, 2);
  }

  @Test
  public void addBiconsumerAsArgument() {
    consumeAsArgument(1, 2, (a, b) -> System.out.println("SUM IS: " + a + b));
  }

  @Test
  public void multiplicateBiconsumerAsArgument() {
    consumeAsArgument(3, 2, (a, b) -> System.out.println("MULTIPLICATE IS: " + a * b));
  }

  static void consumeAsArgument(Integer a, Integer b, BiConsumer<Integer, Integer> consumer) {
    consumer.accept(a, b);
  }


  BiConsumer<List<Integer>, List<Integer>> equals =
      (list1, list2) ->
      {
        if (list1.size() != list2.size()) {
          System.out.println(list1 + " different in size " + list2 );
        } else {
          for (int i = 0; i < list1.size(); i++)
            if (list1.get(i) != list2.get(i)) {
              System.out.println(list1 + "<>" + list2 );
              return;
            }
          System.out.println(list1 + "==" + list2);
        }
      };

  @Test
  public void listEquals() {
    equals.accept(
        Arrays.asList(1,2,3),
        Arrays.asList(1,2,3));
  }

  @Test
  public void listNotEquals() {
    equals.accept(
        Arrays.asList(1,2,4),
        Arrays.asList(1,2,3));
  }

}