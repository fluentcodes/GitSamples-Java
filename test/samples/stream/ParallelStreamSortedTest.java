package samples.stream;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class ParallelStreamSortedTest {

    @Test
    public void wrong() {
        final List<String> names = Arrays.asList("Stefan", "Ralph", "Andi", "Mike");

        names.parallelStream()
            .sorted()
            .forEach(System.out::println);
    }

    @Test
    public void ok() {
        final List<String> names = Arrays.asList("Stefan", "Ralph", "Andi", "Mike");
         names.parallelStream()
             .sorted()
             .forEachOrdered(System.out::println);
    }
}
