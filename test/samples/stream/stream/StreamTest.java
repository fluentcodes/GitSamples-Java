package samples.stream.stream;

import java.util.Arrays;
import java.util.Random;
import java.util.function.Supplier;
import java.util.stream.Stream;
import org.junit.Test;
import samples.TestBasics;

public class StreamTest extends TestBasics {
    final static Random RANDOM = new Random();
    @Test
    public void printStreamOf() {
        Stream stream = Stream.of(1, 2.2, 3L, "test");
        stream.forEach(print::log);
    }

    @Test
    public void printObjectArray() {
        Arrays.stream(new Object[] {1, 2.2, 3L, "test"})
            .forEach(print::log);
    }

    @Test
    public void randomFloat() {
        final Supplier<Float> supplier = () -> RANDOM.nextFloat() * 100;
        final Stream<Float> randomStream = Stream
            .generate(supplier)
            .limit(7);
        randomStream.forEach(System.out::println);
    }


    @Test
    public void randomInteger() {
        final Supplier<Integer> supplier = () -> RANDOM.nextInt(100);
        final Stream<Integer> randomStream = Stream
            .generate(supplier)
            .limit(7);
        randomStream.forEach(System.out::println);
    }

}
