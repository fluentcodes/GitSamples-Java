package samples.function.functional_interface;

@FunctionalInterface
public interface MyFunctionalInterface {
  void execute();

  public default void print(String text) {
    System.out.println(text);
  }
}
