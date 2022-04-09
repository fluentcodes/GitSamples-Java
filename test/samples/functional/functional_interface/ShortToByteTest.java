package samples.functional.functional_interface;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.Test;

public class ShortToByteTest {

  @Test
  public void shortToByteMult2() {
    ShortToByteFunction function =  s -> (byte) (s * 2);
    assertEquals((byte)2, function.applyAsByte((short)1));
  }

  @Test
  public void shortToByteMult4() {
    ShortToByteFunction function =  s -> (byte) (s * 4);
    assertEquals((byte)4, function.applyAsByte((short)1));
  }

  @Test
  public void shortToByteAdd12() {
    ShortToByteFunction function =  s -> (byte) (s + 12);
    assertEquals((byte)13, function.applyAsByte((short)1));
  }

  @Test
  public void arrayStream() {
    Short[] array = {(short) 1, (short) 2, (short) 3};
    ShortToByteFunction function =  s -> (byte) (s * 2);
    List<Byte> transformed = Arrays.stream(array).map(function::applyAsByte).collect(Collectors.toList());
    assertEquals((Byte)Short.valueOf("2").byteValue(), transformed.get(0));
  }
}
