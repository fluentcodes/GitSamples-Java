package samples.function.constructor_ref;

import java.util.ArrayList;
import org.junit.Test;

public class RefClassTest {
  @Test
  public void constructorReferenceParams() {
    RefClassArg<RefClass,Integer> refClassArg = RefClass::new;
    Object object = refClassArg.create(42);
    System.out.println("constructedWithParam "+ object);
  }

  @Test
  public void constructorReferenceEmpty() {
    RefClassEmpty<RefClass> constructorEmpty
        = RefClass::new;
    System.out.println("constructedDefault "+ constructorEmpty.create());
  }
}
