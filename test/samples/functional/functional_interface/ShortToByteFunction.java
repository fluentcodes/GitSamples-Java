package samples.functional.functional_interface;

@FunctionalInterface
public interface ShortToByteFunction {
  byte applyAsByte(short s);
}
