package samples.optionals.flatMap;

import java.util.Optional;

public class Nested {
   private Inner inner;

  public Nested(String value) {
    this.inner = new Inner(value);
  }

  public Optional<Inner> getOptional() {
    return Optional.ofNullable(inner);
  }

  public Inner getInner() {
    return inner;
  }
}
