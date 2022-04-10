package samples.stream.string;

import static org.junit.Assert.assertEquals;

import java.util.stream.Collectors;
import org.junit.Test;

public class StringStreamTest {
  @Test
  public void chars() {
    String concatenated = String.join(":", "foobar", "foo", "bar");
    System.out.println("concatenated: " + concatenated);

    String chars = "foobar:foo:bar"
        .chars()
        .distinct()
        .mapToObj(c -> String.valueOf((char) c))
        .collect(Collectors.joining(","));
    assertEquals("f,o,b,a,r,:", chars);
  }
}
