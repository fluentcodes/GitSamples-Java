package samples.behavioral.observer.news;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class ObserverTest {

  @Test
  public void whenChangingNewsAgencyState_thenNewsChannelNotified() {

    Agency observable = new Agency();
    Channel observer = new Channel();

    observable.addObserver(observer);

    observable.setNews("news");
    assertEquals(observer.getNews(), "news");
  }
}
