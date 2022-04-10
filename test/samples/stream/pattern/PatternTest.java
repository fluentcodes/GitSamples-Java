package samples.stream.pattern;

import static org.junit.Assert.assertEquals;

import java.util.regex.Pattern;
import java.util.stream.Collectors;
import org.junit.Test;

public class PatternTest {
  @Test
  public void splitAsStream() {
    String concatenated = String.join(":", "foobar", "foo", "bar");
    String sorted = Pattern.compile(":")
        .splitAsStream("foobar:foo:bar")
        .sorted()
        .collect(Collectors.joining(":"));

    assertEquals("bar:foo:foobar", sorted);
  }
}
