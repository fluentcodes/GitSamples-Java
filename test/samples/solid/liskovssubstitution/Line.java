package samples.solid.liskovssubstitution;

import samples.solid.singleresponsibility.forms.Forms;

public class Line implements Forms {
  private final int length;
  public Line(int length) {
    this.length = length;
  }

  @Override
  public double area() {
    throw new RuntimeException("No aread defined for Line!");
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "(" + length + ")";
  }
}
