package samples.behavioral.mediator;

public class LampMediated {
  private Mediator mediator;
  private boolean on = false;

  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }

  public void turnOn() {
    this.mediator.plugin();
    on = true;
  }

  public void turnOff() {
    on = false;
    this.mediator.unplug();
  }

  boolean isOn() {
    return on;
  }
}

