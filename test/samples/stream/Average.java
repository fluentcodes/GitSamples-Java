package samples.stream;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.partitioningBy;
import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.OptionalDouble;
import org.junit.Test;

public class Average {
    @Test
    public void averageEmpty() {
        final double[] values = {};
        final OptionalDouble average = Arrays.stream(values).average();
        assertEquals(OptionalDouble.empty(), average);
    }

    @Test
    public void average() {
        final double[] values = {1.1, 4.5};
        final OptionalDouble average = Arrays.stream(values).average();
        assertEquals(2.8, average.getAsDouble(), 0.01);
    }
}
