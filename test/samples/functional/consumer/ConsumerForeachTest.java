package samples.functional.consumer;

import static samples.functional.ComparatorTest.ROLES;

import java.util.function.Consumer;
import org.junit.Test;

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