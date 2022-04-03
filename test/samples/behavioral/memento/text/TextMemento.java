package samples.behavioral.memento.text;

public class TextMemento {

    private String text;

    public TextMemento(String text) {
        this.text = text;
    }

    public String get() {
        return text;
    }
}
