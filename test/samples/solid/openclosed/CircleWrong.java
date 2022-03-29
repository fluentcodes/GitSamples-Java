package samples.solid.openclosed;

public class CircleWrong {
  private double radius;

  public CircleWrong(double radius) {
    this.radius = radius;
  }

  @Override
  public String toString() {
    return this.getClass().getSimpleName() + "(" + radius + ")";
  }

  public double getRadius() {
    return radius;
  }
}
