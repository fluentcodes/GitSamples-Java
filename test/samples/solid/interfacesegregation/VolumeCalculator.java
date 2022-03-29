package samples.solid.interfacesegregation;

import java.util.stream.Stream;
import samples.solid.singleresponsibility.forms.AreaCalculator;

public class VolumeCalculator extends AreaCalculator implements Forms3DWrong{
  public VolumeCalculator(Forms3DWrong[] forms) {
    super(forms);
  }

  @Override
  public double volume() {
    return Stream.of((Forms3DWrong[]) getForms())
        .map(x -> x.volume())
        .reduce(0.0, (a, b) -> a + b);
  }


}
