package samples.optionals.flatMap;

import java.util.Optional;

public class  Inner {
  private String foo;
  Inner (String value) {
      this.foo = value;
  }

  public Optional<String> getOptional() {
    return Optional.ofNullable(foo);
  }
  public String getFoo() {
    return foo;
  }
}
