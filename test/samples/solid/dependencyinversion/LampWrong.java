package samples.solid.dependencyinversion;

public class LampWrong {
  private boolean shine;

  public void switchOn() {
    shine = true;
  }

  public void switchOff() {
    shine = false;
  }
}
