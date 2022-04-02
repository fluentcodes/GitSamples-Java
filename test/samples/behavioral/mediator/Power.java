package samples.behavioral.mediator;

public class Power {
  private boolean connected = false;

  public void plugin() {
    System.out.println("3. Power plugin");
    connected = true;
  }

  public void unplug() {
    System.out.println("3. Power unplug");
    connected = false;
  }
}
