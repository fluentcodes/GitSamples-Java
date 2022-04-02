package samples.behavioral.observer.newsWithPropertyChangeListener;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ObserverTest {
  @Test
  public void testNews() {

    Agency observable = new Agency();
    Channel observer = new Channel();

    observable.addPropertyChangeListener(observer);

    observable.setNews("news");
    assertEquals(observer.getNews(), "news");
  }
}
