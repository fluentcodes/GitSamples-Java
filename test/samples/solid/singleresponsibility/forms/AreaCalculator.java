package samples.solid.singleresponsibility.forms;

import java.util.stream.Collectors;
import java.util.stream.Stream;

public class AreaCalculator implements Forms{
  final Forms[] forms;
  public AreaCalculator(Forms[] forms) {
    this.forms = forms;
  }

  public Forms[] getForms() {
    return forms;
  }

  @Override
  public double area() {
    return Stream.of(forms)
        .map(x->x.area())
        .reduce(0.0, (a,b) -> a + b);
  }

  @Override
  public String toString() {
    return Stream.of(forms)
        .map(x->x.toString())
        .collect(Collectors.joining(","));
  }
}
