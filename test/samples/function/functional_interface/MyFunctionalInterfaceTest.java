package samples.function.functional_interface;

import org.junit.Test;

public class MyFunctionalInterfaceTest {
  @Test
  public void test() {
    MyFunctionalInterface function =  ()->System.out.println("Hello from function ");
    function.execute();
    function.print("Hello from default");
  }
}
