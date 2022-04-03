package samples.behavioral.memento.text;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

class TextCaretakerTest {

    @Test
    void testUndo() {
        TextCaretaker textEditor = new TextCaretaker(new TextMemento(""));
        textEditor.write("A");
        textEditor.write("B");
        assertEquals("AB",
            textEditor.print());

        textEditor.save();
        textEditor.write("C");
        textEditor.undo();

        assertEquals("AB",
            textEditor.print());
    }
}