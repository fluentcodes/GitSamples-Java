package samples.concurrent;

import static org.junit.Assert.assertNotNull;
import static samples.concurrent.RemoteProvider.httpGet;

import org.junit.Test;

public class RemoteProviderTest {
  @Test
  public void testHttpGet() {
    String body = httpGet();
    assertNotNull(body);
  }

  @Test
  public void testHttpGetHeise() {
    String body = httpGet("http://www.heise.de");
    assertNotNull(body);
  }

  @Test
  public void testHttpGetHttpsHeise() {
    String body = httpGet("https://www.heise.de");
    assertNotNull(body);
  }

  @Test
  public void testHttpGetHttpsGoogle() {
    String body = httpGet("https://www.google.com");
    assertNotNull(body);
  }
}