package samples.structural.decorator;

public class SecondDecorator extends Decorator {

  public SecondDecorator(DecoratedObject decoratedObject) {
    super(decoratedObject);
  }
  public void describe() {
    System.out.print("From Second Decorator - ");
    super.describe();
  }
}
