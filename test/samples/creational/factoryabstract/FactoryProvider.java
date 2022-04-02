package samples.creational.factoryabstract;

public class FactoryProvider {
  public static AbstractFactory getFactory(String choice){

    if("Form".equalsIgnoreCase(choice)){
      return new FormsFactory();
    }
    else if("Color".equalsIgnoreCase(choice)){
      return new ColorFactory();
    }

    return null;
  }
}
