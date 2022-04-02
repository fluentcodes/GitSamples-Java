package samples.creational.factoryabstract;

import static org.junit.Assert.assertEquals;

import java.text.Normalizer;
import org.junit.Test;
import samples.solid.singleresponsibility.forms.Forms;

public class AbstractFactoryTest {
  @Test
  public void testTriangle() {
    assertEquals(0.5, ((FormsFactory)FactoryProvider.getFactory(Forms.NAME))
        .create(Triangle.NAME)
        .area(), 0.01);
  }

  @Test
  public void testRed() {
    ((ColorFactory)FactoryProvider.getFactory(Color.NAME))
        .create(RedColor.NAME).print();
  }

  @Test(expected = ClassCastException.class)
  public void testException() {
    ((ColorFactory)FactoryProvider.getFactory(Forms.NAME))
        .create(RedColor.NAME).print();
  }

  @Test(expected = NullPointerException.class)
  public void testMissingFactory() {
    ((ColorFactory)FactoryProvider.getFactory("notexists"))
        .create(RedColor.NAME).print();
  }

}
