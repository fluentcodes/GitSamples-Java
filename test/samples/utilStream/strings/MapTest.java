package samples.utilStream.strings;

import java.util.Arrays;
import org.junit.Test;

public class MapTest {
  // From http://www.angelikalanger.com/Articles/EffectiveJava/71.Java8.Lambdas/71.Java8.Lambdas.html
  @Test
  public void charAppendToStringBuilder() {
    System.out.println("Array stream with map and StringBuilder setting '.txt' as suffix");
    char[] suffix = new char[] {'.','t','x','t'};

    Arrays.stream(new String[] {"readme", "releasenotes"})
        .map( StringBuilder::new)
        .map(s->s.append(suffix))
        .forEach(System.out::println);
  }
}
