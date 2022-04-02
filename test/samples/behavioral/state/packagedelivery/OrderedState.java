package samples.behavioral.state.packagedelivery;

public class OrderedState implements PackageState {

    @Override
    public void next(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void prev(Package pkg) {
        System.out.println("The package is in it's root state.");
    }

    @Override
    public void printStatus() {
        System.out.println("samples.behavioral.state.a.Package ordered, not delivered to the office yet.");
    }

    @Override
    public String toString() {
        return "samples.behavioral.state.a.OrderedState{}";
    }
}