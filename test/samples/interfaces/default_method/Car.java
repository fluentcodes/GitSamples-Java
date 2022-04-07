package samples.interfaces.default_method;

public class Car implements Vehicle, FourWheeler {
  public void iAm() {
    System.out.println("I am a car!");
    Vehicle.super.iAm();
    FourWheeler.super.iAm();
    Vehicle.blowHorn();

  }
}
