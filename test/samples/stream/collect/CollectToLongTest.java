package samples.stream.collect;

import static org.junit.Assert.assertEquals;

import java.util.function.ToIntFunction;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import samples.models.Person;

public class CollectToLongTest {
  @Test
  public void count() {
    Pattern pattern = Pattern.compile(".*@gmail\\.com");
    long count = Stream.of("bob@gmail.com", "alice@hotmail.com")
        .filter(pattern.asPredicate())
        .count();
    assertEquals(1L, count);
  }
}
