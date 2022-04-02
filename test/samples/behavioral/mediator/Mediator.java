package samples.behavioral.mediator;

public class Mediator {
  private ButtonMediated button;
  private Power power;
  private LampMediated lamp;
  private boolean on = false;


  public void setButton(ButtonMediated button) {
    this.button = button;
    this.button.setMediator(this);
  }

  public void setFan(LampMediated fan) {
    this.lamp = fan;
    this.lamp.setMediator(this);
  }

  public void setPowerSupplier(Power powerSupplier) {
    this.power = powerSupplier;
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

  public void plugin() {
    power.plugin();
  }

  public void unplug() {
    power.unplug();
  }

  boolean isOn() {
    return on;
  }
}

