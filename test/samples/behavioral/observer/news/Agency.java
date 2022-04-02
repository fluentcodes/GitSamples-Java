package samples.behavioral.observer.news;

import java.util.ArrayList;
import java.util.List;

public class Agency {
    private String news;
    private List<ObserverInterface> channels = new ArrayList<>();

    public void addObserver(ObserverInterface channel) {
        this.channels.add(channel);
    }

    public void removeObserver(ObserverInterface channel) {
        this.channels.remove(channel);
    }

    public void setNews(String news) {
        this.news = news;
        for (ObserverInterface channel : this.channels) {
            channel.update(this.news);
        }
    }
}
