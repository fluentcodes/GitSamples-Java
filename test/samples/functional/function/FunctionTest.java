package samples.functional.function;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

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

  @Test
  public void andThen() throws Exception {
    final Function<String, Double> functionToDouble = s -> {
      System.out.println("0. " + s);
      return new Double(s);
    };
    final Function<Double, Double> functionAdd100 = d -> {
      System.out.println("1. " + d);
      return d + 100.0;
    };
    final Function<String, Double> chained = functionToDouble
        .andThen(functionAdd100);

    double[] doubles = Stream.of("2", "3", "1")
        .map(chained)
        .mapToDouble(x->x)
        .toArray();
    assertEquals(102.0, doubles[0], 0.01);
  }
}
