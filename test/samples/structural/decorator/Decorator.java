package samples.structural.decorator;

public class Decorator extends DecoratedObject {
  final DecoratedObject decoratedObject;
  public Decorator(DecoratedObject decoratedObject) {
    this.decoratedObject = decoratedObject;
  }
  public void describe() {
    decoratedObject.describe();
  }
}
