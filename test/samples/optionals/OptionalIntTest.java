package samples.optionals;

import java.util.OptionalInt;
import org.junit.Assert;
import org.junit.Test;

public class OptionalIntTest {
  @Test
  public void testOptionalPrimitive() throws Exception {
    final OptionalInt maybeInt = OptionalInt.of(4711);
    final OptionalInt emptyInt = OptionalInt.empty();

    Assert.assertEquals(4711, maybeInt.orElse(-1));
    Assert.assertEquals(-1, emptyInt.orElse(-1));

    System.out.println("OptionalInt.orElse()");
    System.out.println(maybeInt.orElse(-2));
    System.out.println(emptyInt.orElse(-2));

    System.out.println("OptionalInt.ifPresent()");
    maybeInt.ifPresent(System.out::println);
    emptyInt.ifPresent(System.out::println);
  }
}
