package samples.stream;

import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.IntStream;
import java.util.stream.Stream;
import org.junit.Test;

public class GenerateTest {
  final static Random RANDOM = new Random();
  final static Supplier<Float> FLOAT_SUPPLIER = () -> RANDOM.nextFloat() * 100;
  final static Supplier<Integer> INTEGER_SUPPLIER = () -> RANDOM.nextInt(100);

  @Test
  public void randomFloat() {
    final Stream<Float> randomStream = Stream
        .generate(FLOAT_SUPPLIER)
        .limit(7);
    randomStream.forEach(System.out::println);
  }

  @Test
  public void randomInteger() {
    final Stream<Integer> randomStream = Stream
        .generate(INTEGER_SUPPLIER)
        .limit(7);
    randomStream.forEach(System.out::println);
  }

  @Test
  public void randomIntFromFloat() {
    final Stream<Float> floatStream = Stream
        .generate(FLOAT_SUPPLIER)
        .limit(7);
    final IntStream integerStream = floatStream
        .mapToInt(val -> val.intValue());
    integerStream.forEach(System.out::println);
  }
}