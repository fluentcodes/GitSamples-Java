package samples.behavioral.bridge.accountbalance;
@FunctionalInterface
public interface Feedback {
  void log(String message);

  static Feedback info() {
    return message -> System.out.println("info: " + message);
  }
  static Feedback warning() {
    return message -> System.out.println("warning: " + message);
  }
}
