package samples.solid.singleresponsibility.forms;

public class Circle implements Forms {
  public static final String NAME = "CIRCLE";
  private double radius;
  public Circle(double radius) {
    this.radius = radius;
  }
  @Override
  public double area() {
    return Math.PI * radius;
  }
  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "(" + radius + ")";
  }

  public double getRadius() {
    return radius;
  }
}
