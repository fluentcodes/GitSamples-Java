package samples.functional.function_bi;

import org.junit.Test;

import java.util.Arrays;
import java.util.function.ToDoubleBiFunction;
import java.util.function.ToIntBiFunction;
import java.util.function.ToLongBiFunction;
import java.util.stream.Stream;

import static org.junit.Assert.assertEquals;

public class ToLongBiFunctionTest {
  final static ToLongBiFunction<Integer, Integer> ADD = (a, b) -> a + b;    // lambda expression

  @Test
  public void apply() {
    long added = ADD.applyAsLong(50, 5);
    assertEquals(55, added);
  }

}
