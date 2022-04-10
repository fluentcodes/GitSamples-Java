package samples.functional.function;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class FunctionTest {
  Function<ObjectIn, ObjectOut> FUNCTION = x -> new ObjectOut(x.getValue().length());

  @Test
  public void test() {
    assertEquals(10, FUNCTION
        .apply(new ObjectIn("GitSamples"))
        .getValue());
  }

  @Test
  public void list() {
    Function<String, ObjectOut> fromString = x -> new ObjectOut(new ObjectIn(x).getValue().length());
    Stream<String> stream = Arrays.asList("Tim", "Tom", "Micha")
        .stream();
    List<ObjectOut> values = stream
        .map(fromString::apply)
        .collect(Collectors.toList());
    assertEquals(3L, values.get(1).getValue());
  }
}
