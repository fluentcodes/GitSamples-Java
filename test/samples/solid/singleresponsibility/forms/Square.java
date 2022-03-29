package samples.solid.singleresponsibility.forms;

public class Square implements Forms {
  private double length;
  public Square(double length) {
    this.length = length;
  }

  @Override
  public double area() {
    return length * length;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "(" + length + ")";
  }

  public double getLength() {
    return length;
  }
}
