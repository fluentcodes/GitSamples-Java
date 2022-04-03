package samples.utilStream.strings;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class FilterTest {
  static final List<String> LIST_STRING = Arrays.asList("abc", "", "bc", "efg", "abcd", "", "jkl");

  @Test
  public void countEmpty() {
    long count = LIST_STRING.stream().filter(string -> string.isEmpty()).count();
    assertEquals(2, count);
  }

  @Test
  public void countNotEmpty() {
    long count = LIST_STRING.stream().filter(string -> !string.isEmpty()).count();
    assertEquals(5, count);
  }

  @Test
  public void countLength3() {
    long count = LIST_STRING.stream().filter(string -> string.length() == 3).count();
    assertEquals(3, count);
  }

  @Test
  public void joinNotEmpty() {
    String collect = LIST_STRING.stream().filter(string -> !string.isEmpty()).collect(Collectors.joining(", "));
    assertEquals("abc, bc, efg, abcd, jkl", collect);
  }

  @Test
  public void countParallelStream() {
    Long count = LIST_STRING.parallelStream().filter(string -> string.isEmpty()).count();
    assertEquals(Long.valueOf(2L), count);
  }
}
