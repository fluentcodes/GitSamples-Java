package samples.stream.stream;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Optional;
import java.util.stream.Stream;
import samples.models.Person;
import org.junit.Test;

import java.util.List;

/**
 * Created by werner, ecube on 07.08.16.
 * From http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class ReduceTest {
  @Test
  public void concat() {
    final Stream<String> stream = Stream.of("A", "B", "C");
    final Optional<String> stringConcat = stream.reduce((s1, s2) -> s1 + ", " + s2);
    assertEquals("A, B, C", stringConcat.get());
  }

  @Test
  public void multiplicate() {
    final Stream<Integer> integers = Stream.of(1, 2, 3);
    final Optional<Integer> multiplication = integers.reduce((s1, s2) -> s1 * s2);
    assertEquals(Integer.valueOf(6), multiplication.get());
  }

  @Test
  public void add() {
    final Stream<Integer> empty = Stream.of(1, 2, 3);;
    final Optional<Integer> addition = empty.reduce((s1, s2) -> s1 + s2);
    assertEquals(Integer.valueOf(6), addition.get());
  }

  @Test
  public void addEmpty() {
    final Stream<Integer> empty = Stream.of();
    final Optional<Integer> addition = empty.reduce((s1, s2) -> s1 + s2);
    assertFalse( addition.isPresent());
  }

    @Test
    public void testReduce() {
        List <Person> persons= Person.getPersonList();
        System.out.println("Get the oldest person with reduce:");
        persons
            .stream()
            .reduce((p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2)
            .ifPresent(p->System.out.println(p.getName() + " " + p.getAge()));

        System.out.println("Create a new Persone with accumulator:");
        //---
        Person result =
            persons
                .stream()
                .reduce(new Person("", "", 0), (p1, p2) -> {
                    p1.age += p2.getAge();
                    p1.name += p2.getName();
                    return p1;
                });

        System.out.format("name=%s; age=%s\n", result.name, result.age);

        System.out.println("Now with three arguments: ");
        Integer ageSum = persons
                .stream()
                .reduce(0, (sum, p) -> sum += p.age, (sum1, sum2) -> sum1 + sum2);

        System.out.println("ageSum: " + ageSum);

        System.out.println("Print out what happened within the functions: ");
        ageSum = persons
            .stream()
            .reduce(0,
                (sum, p) -> {
                    System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                    return sum += p.age;
                },
                (sum1, sum2) -> {
                    System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                    return sum1 + sum2;
                });

        System.out.println("Write out what happened parallel: ");
        ageSum = persons
            .parallelStream()
            .reduce(0,
                (sum, p) -> {
                    System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
                    return sum += p.age;
                },
                (sum1, sum2) -> {
                    System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
                    return sum1 + sum2;
                });
    }

}
