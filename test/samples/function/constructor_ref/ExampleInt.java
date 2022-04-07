package samples.function.constructor_ref;

public class ExampleInt {

    int anInt;

    ExampleInt() {
    }

    ExampleInt(int a) {
        this.anInt = a;
    }

    public int getAnInt() {
        return anInt;
    }

    public String toString() {
        return "RefClass: " + anInt;
    }
}
