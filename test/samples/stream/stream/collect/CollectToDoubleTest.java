package samples.stream.stream.collect;

import static org.junit.Assert.assertEquals;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.ToIntFunction;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;
import org.junit.Test;
import samples.models.Person;

public class CollectToDoubleTest {
  @Test
  public void averageinIntPersonAge() {
    Stream<Person> stream = Person.getPersonList().stream();
    ToIntFunction<Person> function = p -> p.getAge();
    Double averageAge = stream
        .collect(
            Collectors.averagingInt(function)
        );

    assertEquals(24.166666666666668, averageAge, 0.01);
  }

  @Test
  public void summarizingIntPersonByAge () {
    List<Person> persons = Person.getPersonList();

    ToIntFunction<Person> function = Person::getAge;

    IntSummaryStatistics ageSummary =
        persons
            .stream()
            .collect(Collectors.summarizingInt(function));

    System.out.println("IntSummarayStatistics:" + ageSummary);
    assertEquals(24.166666666666668, ageSummary.getAverage(), 0.01);
    assertEquals(145, ageSummary.getSum());
    assertEquals(6, ageSummary.getCount());
    assertEquals(7, ageSummary.getMin());
    assertEquals(42, ageSummary.getMax());
  }

  @Test
  public void averageEmpty() {
    final OptionalDouble average = Arrays.stream(new double[]{})
        .average();
    assertEquals(OptionalDouble.empty(), average);
  }

  @Test
  public void average() {
    final double[] values = {1.1, 4.5};
    final OptionalDouble average = Arrays
        .stream(new double[]{1.1, 4.5})
        .average();
    assertEquals(2.8, average.getAsDouble(), 0.01);
  }

  @Test
  public void averageDoubleStream() {
    final OptionalDouble average = DoubleStream
        .of(1.1, 4.5)
        .average();
    assertEquals(2.8, average.getAsDouble(), 0.01);
  }
}
