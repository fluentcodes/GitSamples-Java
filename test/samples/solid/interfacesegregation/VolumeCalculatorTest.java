package samples.solid.interfacesegregation;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import samples.solid.liskovssubstitution.Line;
import samples.solid.singleresponsibility.forms.AreaCalculator;
import samples.solid.singleresponsibility.forms.Forms;
import samples.solid.singleresponsibility.forms.Square;

public class VolumeCalculatorTest {
  private static Forms3DWrong[] FORMS = new Forms3DWrong[] {new DiceWrong(1), new Square3DWrong(5)};

  public void VolumeCalculatorAreaTest() {
    assertEquals(3.0, new VolumeCalculator(FORMS).area(), 0.01);
  }


  @Test(expected = RuntimeException.class)
  public void VolumeCalculatorVolumeTest() {
    new VolumeCalculator(FORMS).volume();
  }
}
