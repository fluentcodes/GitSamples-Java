package samples.function.functional_interface;

@FunctionalInterface
public interface ShortToByteFunction {
  byte applyAsByte(short s);
}
