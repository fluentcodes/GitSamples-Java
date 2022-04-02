package samples.creational.prototype;

public class Prototype2 extends Prototype {
  public Prototype2(final String value) {
    super(value);
  }

  @Override
  public Prototype clone() throws CloneNotSupportedException {
    return (Prototype2) super.clone();
  }

  @Override
  void print() {
    System.out.println(this.getClass().getSimpleName());
  }
}
