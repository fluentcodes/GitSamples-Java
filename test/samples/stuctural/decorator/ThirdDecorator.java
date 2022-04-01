package samples.stuctural.decorator;

public class ThirdDecorator extends Decorator {

  public ThirdDecorator(DecoratedObject decoratedObject) {
    super(decoratedObject);
  }
  public void describe() {
    System.out.print("From Third Decorator - ");
    super.describe();
  }
}
