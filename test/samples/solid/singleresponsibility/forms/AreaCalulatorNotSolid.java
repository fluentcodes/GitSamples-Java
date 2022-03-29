package samples.solid.singleresponsibility.forms;

import java.util.stream.Stream;

public class AreaCalulatorNotSolid implements Forms{
  final Forms[] forms;
  public AreaCalulatorNotSolid(Forms[] forms) {
    this.forms = forms;
  }

  @Override
  public double area() {
    return Stream.of(forms)
        .map(x->x.area())
        .reduce(0.0, (a,b) -> a + b);
  }

  public void printOut() {
     System.out.println(new AreaCalculator(forms).toString());
  }
}
