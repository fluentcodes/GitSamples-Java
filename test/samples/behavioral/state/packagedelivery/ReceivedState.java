package samples.behavioral.state.packagedelivery;

public class ReceivedState implements PackageState {

    @Override
    public void next(Package pkg) {
        System.out.println("This package is already received by a client.");
    }

    @Override
    public void prev(Package pkg) {
        pkg.setState(new DeliveredState());
    }

    @Override
    public void printStatus() {
        System.out.println("samples.behavioral.state.a.Package was received by client.");
    }

    @Override
    public String toString() {
        return "samples.behavioral.state.a.ReceivedState{}";
    }
}