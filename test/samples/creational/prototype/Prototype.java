package samples.creational.prototype;

public abstract class Prototype implements Cloneable {
  private String value;
  public Prototype(final String value) {
    this.value = value;
  }
  public Prototype clone() throws CloneNotSupportedException{
    return (Prototype) super.clone();
  }
  abstract void print();

  public String getValue() {
    return value;
  }

  public void setValue(String value) {
    this.value = value;
  }
}
