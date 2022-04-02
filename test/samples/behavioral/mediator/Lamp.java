package samples.behavioral.mediator;

public class Lamp {
  private final Button button;
  private final Power power;
  private boolean on = false;

  public Lamp(Power power) {
    this.button = new Button(this);
    this.power = power;
  }

  public Button getButton() {
    return button;
  }

   void turnOn() {
    System.out.println("2. Lamp turn on");
    power.plugin();
    on = true;
  }

  void turnOff() {
    System.out.println("2. Lamp turn off");
    on = false;
    power.unplug();
  }

  boolean isOn() {
    return on;
  }
}

