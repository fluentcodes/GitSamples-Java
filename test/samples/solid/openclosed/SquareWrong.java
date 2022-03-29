package samples.solid.openclosed;

public class SquareWrong {
  private double length;

  public SquareWrong(double length) {
    this.length = length;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "(" + length + ")";
  }

  public double getLength() {
    return length;
  }
}
