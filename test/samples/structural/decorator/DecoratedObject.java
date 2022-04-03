package samples.structural.decorator;

public class DecoratedObject implements DecoratedObjectInterface {
  public void describe() {
    System.out.print(this.getClass().getSimpleName());
  }
}
