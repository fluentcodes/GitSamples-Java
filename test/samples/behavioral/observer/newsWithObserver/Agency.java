package samples.behavioral.observer.newsWithObserver;

import java.util.Observable;

public class Agency extends Observable {
    private String news;

    public void setNews(String news) {
        this.news = news;
        setChanged();
        notifyObservers(news);
    }
}
