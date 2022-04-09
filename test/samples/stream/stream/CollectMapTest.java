package samples.stream.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import org.junit.Test;

import static java.util.stream.Collectors.*;
import static org.junit.Assert.assertEquals;
public class CollectMapTest {
    final List<String> names = Arrays.asList("Stefan", "Ralph", "Andi", "Mike", "Florian", "Michael", "Sebastian");

    @Test
    public void groupingByLength() {
        Map<Integer, List<String>> mapByLength = names.stream().collect(groupingBy(String::length));
        assertEquals("Sebastian", mapByLength.get(9).get(0));
    }

    @Test
    public void partitioningByLengthGreater4() {
        Map<Boolean, List<String>> mapGreater4 = names.stream()
            .collect(partitioningBy(str -> str.length() > 4));
        assertEquals("Andi", mapGreater4.get(false).get(0));
    }
}
