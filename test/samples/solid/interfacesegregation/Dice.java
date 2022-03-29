package samples.solid.interfacesegregation;

import samples.solid.singleresponsibility.forms.Forms;

public class Dice implements Forms3D, Forms {
  private final double length;

  public Dice(int length) {
    this.length = length;
  }

  public double area() {
    return 6 * length * length;
  }

  public double volume() {
    return length * length * length;
  }
}
