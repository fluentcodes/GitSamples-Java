package samples.interfaces.default_method;

interface Vehicle {
  default void iAm() {
    System.out.println("I am a vehicle!");
  }

  static void blowHorn() {
    System.out.println("Blowing horn!!!");
  }
}
