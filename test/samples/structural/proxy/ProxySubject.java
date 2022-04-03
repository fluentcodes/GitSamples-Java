package samples.structural.proxy;

public class ProxySubject implements ProxyInterface {
  public ProxySubject() {
    System.out.println(this.getClass().getSimpleName() + ": Make some heavy initialization");
  }
  public void process() {
    System.out.println(this.getClass().getSimpleName() + " process something");
  }
}
