package samples.creational.prototype;

public class Prototype1 extends Prototype {
  public Prototype1(final String value) {
    super(value);
  }
  @Override
  public Prototype clone() throws CloneNotSupportedException {
    return (Prototype1) super.clone();
  }

  @Override
  void print() {
    System.out.println(this.getClass().getSimpleName());
  }
}
