package samples.behavioral.memento.text;

public class TextCaretaker {

    private TextOriginator originator;
    private TextMemento memento;

    public TextCaretaker(TextMemento memento) {
        this.memento = memento;
    }

    public void write(String text) {
        originator.add(text);
    }

    public String print() {
        return originator.get();
    }

    public void save() {
        memento = originator.save();
    }

    public void undo() {
        originator.restore(memento);
    }
}
