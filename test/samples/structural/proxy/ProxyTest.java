package samples.structural.proxy;

import org.junit.Test;

public class ProxyTest {
  /**
   * Heavy initialization occures only one time
   */
  @Test
    public void test() {
      Proxy proxy = new Proxy();
      proxy.process();
      proxy.process();
    }

  /**
   * Heavy initialization occures each time
   */
  @Test
  public void testNew() {
    new Proxy().process();
    new Proxy().process();
  }
}
