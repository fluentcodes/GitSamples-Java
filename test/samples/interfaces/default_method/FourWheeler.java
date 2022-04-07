package samples.interfaces.default_method;

interface FourWheeler {
  default void iAm() {
    System.out.println("I am a four wheeler!");
  }
}
