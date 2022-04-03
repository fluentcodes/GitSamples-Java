## [GitSamples](/../../tree/master) - [Mediator Pattern](/../../tree/java-design-pattern/test/samples/behavioural/state): Text Window Example

[TextCaretaker](TextCaretaker.java) has the two instance vars:
* [TextOriginator](TextOriginator.java): Actual text
* [TextMemento](TextMemento.java): Saved text

With the **undo** method the [TextOriginator](TextOriginator.java) will be set 
to the state of [TextMemento](TextMemento.java):

    public void undo() {
        originator.restore(memento);
    }


### Links
* https://www.baeldung.com/java-interpreter-pattern