package samples.stuctural.proxy;

public class Proxy implements ProxyInterface {
  private ProxySubject proxySubject;
  public void process() {
    if (proxySubject == null) {
      proxySubject = new ProxySubject();
    }
    proxySubject.process();
  }
}
