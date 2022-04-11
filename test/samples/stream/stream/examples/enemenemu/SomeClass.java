package samples.stream.stream.examples.enemenemu;

import java.util.Locale;

class SomeClass {

  private enum EneMeneMuh {BIST, DU, ENE, MENE, MUH, RAUS, UND}

  private final EneMeneMuh value;

  public static SomeClass bist() {
    return valueOf(EneMeneMuh.BIST);
  }

  public static SomeClass du() {
    return valueOf(EneMeneMuh.DU);
  }

  public static SomeClass ene() {
    return valueOf(EneMeneMuh.ENE);
  }

  public static SomeClass mene() {
    return valueOf(EneMeneMuh.MENE);
  }

  public static SomeClass muh() {
    return valueOf(EneMeneMuh.MUH);
  }

  public static SomeClass raus() {
    return valueOf(EneMeneMuh.RAUS);
  }

  public static SomeClass und() {
    return valueOf(EneMeneMuh.UND);
  }

  private static SomeClass valueOf(final EneMeneMuh value) {
    return new SomeClass(value);
  }

  private SomeClass(final EneMeneMuh value) {
    this.value = value;
  }

  public SomeClass(final String stringValue) {
    this(EneMeneMuh.valueOf(stringValue.toUpperCase(Locale.getDefault())));
  }

  @Override
  public boolean equals(final Object other) {
    if (other == null || getClass() != other.getClass()) {
      return false;
    }
    return this == other || value == ((SomeClass) other).value;
  }

  @Override
  public int hashCode() {
    return value.hashCode();
  }
}
