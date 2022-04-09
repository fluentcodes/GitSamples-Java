package samples.functional.supplier;

import org.junit.Test;

import java.util.function.Consumer;

import static samples.functional.ComparatorTest.ROLES;

public class ConsumerForeachTest {
  /**
   * Use Itrable.foreach(Consumer method) from Java8 in interable
   */
  @Test
  public void foreachListConsumer() {
    Consumer<String> consumer = s -> System.out.println("Accept & Consumed: " + s);
    ROLES.forEach(consumer);
  }
}