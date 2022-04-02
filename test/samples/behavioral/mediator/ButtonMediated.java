package samples.behavioral.mediator;

public class ButtonMediated {
  private Mediator mediator;

  public void setMediator(Mediator mediator) {
    this.mediator = mediator;
  }
  public void press() {
    mediator.press();
  }
}
