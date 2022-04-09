package samples.functional.consumer;

import java.util.Arrays;
import java.util.function.IntConsumer;
import org.junit.Test;

public class IntConsumerTest {
  @Test
  public void methodReference() {
    IntConsumer consumer = x -> System.out.println("value=" + x);
    Arrays.stream(new Integer[] {1, 2, 3})
        .forEach(x->consumer.accept(x));
  }
}