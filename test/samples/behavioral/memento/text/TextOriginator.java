package samples.behavioral.memento.text;

public class TextOriginator {

    private StringBuilder currentText;

    public TextOriginator() {
        this.currentText = new StringBuilder();
    }

    public String get() {
        return currentText.toString();
    }

    public void add(String text) {
        currentText.append(text);
    }

    public TextMemento save() {
        return new TextMemento(currentText.toString());
    }

    public void restore(TextMemento save) {
        currentText = new StringBuilder(save.get());
    }
}
