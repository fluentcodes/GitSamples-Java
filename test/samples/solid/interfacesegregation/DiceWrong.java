package samples.solid.interfacesegregation;

import samples.solid.singleresponsibility.forms.Forms;

public class DiceWrong implements Forms3DWrong {
  private final double length;

  public DiceWrong(int length) {
    this.length = length;
  }

  public double area() {
    return 6 * length * length;
  }

  public double volume() {
    return length * length * length;
  }
}
