package samples.function.constructor_ref;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.List;
import org.junit.Test;

public class ReferenceTest {

  @Test
  public void empty() {
    ReferenceEmpty<ExampleInt> refClassArg = ExampleInt::new;
    ExampleInt object = refClassArg.create();
    assertEquals(0, object.getAnInt());
  }

  @Test
  public void integer() {
    ReferenceParam<ExampleInt, Integer> refClass = ExampleInt::new;
    ExampleInt object = refClass.create(1);
    assertEquals(1, object.getAnInt());
  }

  @Test
  public void emptyExample() {
    ReferenceEmpty<Example> constructorRef = Example::new;
    Example example = constructorRef.create();
    assertEquals("created by constructor reference", example.getContent());
    System.out.println("\n\n\tcontent = " + constructorRef.create().getContent());
  }

  @Test
  public void args() {
    ReferenceParam<Example, String> constructorRef = Example::new;
    String arg = "hello";
    Example example = constructorRef.create(arg);
    assertEquals(arg, example.getContent());
    System.out.println("\n\n\tcontent by arg = " +
        example.getContent());
  }

  @Test
  public void argsParametrized() {
    ReferenceParamList<Example, String> constructorRef =
        Example::<String>new;
    List<String> arg = new ArrayList<String>();
    Example example = constructorRef.create(arg);
    assertEquals(0, example.getList().size());
    System.out.println("\n\n\tcontents size by parameterized arg = " +
        example.getList().size());
  }

}
