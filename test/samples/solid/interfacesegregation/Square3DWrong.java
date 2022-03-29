package samples.solid.interfacesegregation;

public class Square3DWrong implements Forms3DWrong {
  private final double length;

  public Square3DWrong(double length) {
    this.length = length;
  }

  public double area() {
    return 6 * length * length;
  }

  public double volume() {
    throw new RuntimeException("No volume defined for Sqare");
  }
}
