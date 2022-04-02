package samples.creational.factoryabstract;

public class ColorFactory implements AbstractFactory<Color> {

  @Override
  public Color create(String type) {
    switch(type) {
      case "Blue": return new BlueColor();
      case "Red": return new RedColor();
      case "Yellow": return new YellowColor();
      default: return new RedColor();
    }
  }
}
