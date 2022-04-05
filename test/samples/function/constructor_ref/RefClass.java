package samples.function.constructor_ref;

public class RefClass {

    int a;

    RefClass() {
    }

    RefClass(int a) {
        this.a = a;
    }

    public String toString() {
        return "RefClass: " + a;
    }
}
