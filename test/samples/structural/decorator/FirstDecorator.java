package samples.structural.decorator;

public class FirstDecorator extends Decorator {
  public FirstDecorator(DecoratedObject decoratedObject) {
    super(decoratedObject);
  }

  public void describe() {
    System.out.print("From First Decorator - ");
    super.describe();
  }
}
