package samples.creational.factoryabstract;

import samples.solid.singleresponsibility.forms.Forms;

public class Triangle implements Forms {
  public static final String NAME = "TRIANGLE";
  private double length;
  public Triangle(double length) {
    this.length = length;
  }

  @Override
  public double area() {
    return length * length / 2;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "(" + length + ")";
  }

  public double getLength() {
    return length;
  }
}
