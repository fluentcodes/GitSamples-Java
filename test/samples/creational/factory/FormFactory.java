package samples.creational.factory;

import samples.solid.singleresponsibility.forms.Circle;
import samples.solid.singleresponsibility.forms.Forms;
import samples.solid.singleresponsibility.forms.Square;

public class FormFactory {

  static final String _SQUARE = "SQUARE";
  static final String _CIRCLE = "CIRCLE";

  public Forms create(final String formName) {
    switch (formName) {
      case _SQUARE: return new Square(3);
      case _CIRCLE: return new Circle(3);
      default: return new Square(2);
    }
  }
}
