package samples.stream;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.Test;

public class MapCombinedTest {
  @Test
  public void string_mapToInt_asLongStream_mapToDouble_mapToObj() {
    String convert = Arrays.asList("Mike", "Stefan", "Nikolaos").stream()   // Stream<String>
        .mapToInt(String::length) 		// IntStream
        .asLongStream()          		// LongStream
        .boxed()                   		// Stream<Long>
        .mapToDouble(x -> x * .75) 		// DoubleStream
        .mapToObj(val -> "Val: " + val)
        .collect(Collectors.joining(","));;
    assertEquals("Val: 3.0,Val: 4.5,Val: 6.0", convert);
  }
}
