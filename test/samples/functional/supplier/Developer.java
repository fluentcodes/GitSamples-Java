package samples.functional.supplier;

public class Developer {
  String name;

  Developer() {
  }

  Developer(final String name) {
    this.name = name;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }
}
