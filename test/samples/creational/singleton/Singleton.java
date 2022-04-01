package samples.creational.singleton;

public class Singleton {
  // eager instantiation
  private int value;
  private static final Singleton INSTANCE = new Singleton();

  private Singleton() {}

  public static Singleton getInstance() {
    return INSTANCE;
  }
  public int getValue() {
    return value;
  }

  /**
   * Mutable state for a global valid object
   * @param value to set
   */
  public void setValue(int value) {
    this.value = value;
  }
}
