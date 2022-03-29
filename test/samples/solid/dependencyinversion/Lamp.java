package samples.solid.dependencyinversion;

public class Lamp implements LampInterface{
  private boolean shine;

  public void switchOn() {
    shine = true;
  }

  public void switchOff() {
    shine = false;
  }
}
