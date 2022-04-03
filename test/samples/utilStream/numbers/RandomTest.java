package samples.utilStream.numbers;

import java.util.Random;
import org.junit.Test;

public class RandomTest {
  @Test
  public void random() {
    Random random = new Random();
    random.ints().limit(10).sorted().forEach(System.out::println);
  }
}
