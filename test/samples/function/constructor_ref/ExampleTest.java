package samples.function.constructor_ref;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ExampleTest {
  @Test
  public void empty() {
    ExampleEmpty<Example> constructorRef = Example::new;
    Example example = constructorRef.create();
    assertEquals("created by constructor reference", example.getContent());
    System.out.println("\n\n\tcontent = " + constructorRef.create().getContent());
  }

  @Test
  public void args() {
    ExampleArg<Example, String> constructorRef = Example::new;
    String arg = "hello";
    Example example = constructorRef.create(arg);
    assertEquals(arg, example.getContent());
    System.out.println("\n\n\tcontent by arg = " +
        example.getContent());
  }

  @Test
  public void argsParametrized() {
    ExampleListParam<Example, String> constructorRef =
        Example::<String>new;
    List<String> arg = new ArrayList<String>();
    Example example = constructorRef.create(arg);
    assertEquals(0, example.getList().size());
    System.out.println("\n\n\tcontents size by parameterized arg = " +
        example.getList().size());
  }
}
