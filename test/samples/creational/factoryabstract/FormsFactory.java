package samples.creational.factoryabstract;

import samples.solid.singleresponsibility.forms.Circle;
import samples.solid.singleresponsibility.forms.Forms;
import samples.solid.singleresponsibility.forms.Square;

public class FormsFactory implements AbstractFactory<Forms> {

  @Override
  public Forms create(String type) {
    switch(type) {
      case Square.NAME: return new Square(3);
      case Circle.NAME: return new Circle(1);
      case Triangle.NAME: return new Triangle(1);
      default: return new Square(2);
    }
  }
}
