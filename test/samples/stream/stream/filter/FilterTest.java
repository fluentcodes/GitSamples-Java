package samples.stream.stream.filter;

import java.util.function.Predicate;
import java.util.stream.Stream;
import org.junit.Test;

public class FilterTest {
  /**
   * The following experiments examine the lazyness of intermediate operations
   */
  @Test
  public void lazyness() {
    System.out.println(
        "intermediate operations will only be executed when a terminal operation is present, so println within the filter will not be executed:");

    Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c");

    Predicate<String> predicate = s -> {
      System.out.println("filter: " + s);
      return true;
    };

    stream
        .filter(predicate);
  }
    @Test
    public void foreachNotLazy() {
    System.out.println("println within the filter will executed with terminal foreach:");

      Stream<String> stream = Stream.of("d2", "a2", "b1", "b3", "c");

      Predicate<String> predicate = s -> {
        System.out.println("filter: " + s);
        return true;
      };

    stream
        .filter(predicate)
        .forEach(s -> System.out.println("forEach: " + s));
  }
}
