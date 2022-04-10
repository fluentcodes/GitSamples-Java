package samples.stream.stream;

import java.util.Arrays;
import java.util.stream.Stream;
import org.junit.Test;
import samples.TestBasics;

public class StreamTest extends TestBasics {

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

}
