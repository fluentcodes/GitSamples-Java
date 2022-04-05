package samples.function.constructor_ref;

import java.util.List;

public interface ExampleListParam<T, U> {
  T create(List<U> arg);
}
