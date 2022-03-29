package samples.solid.openclosed;

import samples.solid.singleresponsibility.forms.Forms;

public class AreaCalculatorWrong implements Forms {
  final Object[] forms;

  public AreaCalculatorWrong(Object[] forms) {
    this.forms = forms;
  }

  @Override
  public double area() {
    double result = 0.0;
    for (Object form : forms) {
      if (form instanceof SquareWrong) {
        result += ((SquareWrong) form).getLength() * ((SquareWrong) form).getLength();
      } else if (form instanceof CircleWrong) {
        result += Math.PI * ((CircleWrong) form).getRadius();
      } else {
        throw new RuntimeException("Neither " + SquareWrong.class.getSimpleName() + " nor " + CircleWrong.class.getSimpleName());
      }
    }
    return result;
  }
}
