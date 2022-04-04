package samples.optionals.flatMap;

import java.util.Optional;

public class Outer {
  private Nested nested;
  public Outer() {
  }
  public Outer(String value) {
    nested = new Nested(value);
  }

  public Optional<Nested> getOptional() {
    return Optional.ofNullable(nested);
  }

  public Nested getNested() {
    return nested;
  }
}
