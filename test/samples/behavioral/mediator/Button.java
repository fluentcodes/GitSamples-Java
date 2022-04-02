package samples.behavioral.mediator;

public class Button {
  private Lamp lamp;
  public Button (Lamp lamp) {
    this.lamp = lamp;
  }
  public void press(){
    if(lamp.isOn()){
      System.out.println("1. Button turnoff lamp");
      lamp.turnOff();
    } else {
      System.out.println("1. Button turnon lamp");
      lamp.turnOn();
    }
  }
}
