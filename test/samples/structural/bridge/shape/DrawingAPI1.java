package samples.structural.bridge.shape;

/**
 * "ConcreteImplementor"  1/2
 */
public final class DrawingAPI1 implements DrawingAPI {
  public void drawCircle(final double x, final double y, final double radius) {
    System.out.printf("API1.circle at %f:%f radius %f\n", x, y, radius);
  }
}
