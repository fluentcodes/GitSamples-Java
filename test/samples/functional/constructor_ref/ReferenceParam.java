package samples.functional.constructor_ref;

public interface ReferenceParam<T, U> {
  T create(U arg);
}
