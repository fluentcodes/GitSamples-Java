package samples.functional.constructor_ref;

import java.util.List;

public interface ReferenceParamList<T, U> {
  T create(List<U> arg);
}
