package samples.stream.reduce;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;

import java.util.Arrays;
import java.util.Collection;
import java.util.Optional;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.stream.Stream;
import org.junit.Assert;
import org.junit.Test;
import samples.models.Person;

public class ReduceTest {
  private static final Collection<String> STRING_COLLECTION = Arrays.asList("A", "B", "C");
  private static final Collection<Integer> INTEGER_COLLECTION = Arrays.asList(1, 2, 3);

  @Test
  public void concat() {
    final BinaryOperator<String> operator = (s1, s2) -> s1 + ", " + s2;
    final Stream<String> stream = STRING_COLLECTION.stream();

    final Optional<String> stringConcat = stream
        .reduce(operator);
    assertEquals("A, B, C", stringConcat.get());
  }

  @Test
  public void multiplicate() {
    final Stream<Integer> integers = INTEGER_COLLECTION.stream();
    final Optional<Integer> multiplication = integers.reduce((s1, s2) -> s1 * s2);
    assertEquals(Integer.valueOf(6), multiplication.get());
  }

  @Test
  public void add() {
    final Stream<Integer> empty = INTEGER_COLLECTION.stream();
    ;
    final Optional<Integer> addition = empty
        .reduce((s1, s2) -> s1 + s2);
    assertEquals(Integer.valueOf(6), addition.get());
  }

  @Test
  public void addFunction() {
    BinaryOperator<Integer> biFunction = (s1, s2) -> s1 + s2;
    final Stream<Integer> integerStream = Stream.of(1, 2, 3);
    ;
    final Optional<Integer> addition = integerStream
        .reduce(biFunction);
    assertEquals(Integer.valueOf(6), addition.get());
  }

  @Test
  public void addEmpty() {
    final Stream<Integer> empty = Stream.of();
    final Optional<Integer> addition = empty.reduce((s1, s2) -> s1 + s2);
    assertFalse(addition.isPresent());
  }

  @Test
  public void foldLeft() {
    BinaryOperator<String> operator = (s1, s2) -> s1 + s2;
    Stream<String> stream = Stream.of("A", "B", "C");
    String add = stream
        .reduce("-", operator);
    assertEquals("-ABC", add);
  }

  @Test
  public void foldRight() {
    BinaryOperator<String> operator = (s1, s2) -> s1 + s2;
    Stream<String> stream = Stream.of("A", "B", "C");
    String add = stream
        .reduce("-", operator);
    assertEquals("CBA-", add);
  }

  @Test
  public void personOldest() {
    BinaryOperator<Person> operator = (p1, p2) -> p1.getAge() > p2.getAge() ? p1 : p2;
    Stream<Person> stream = Person.getPersonList().stream();
    Optional<Person> person = stream
        .reduce(operator);
    assertEquals(42, person.get().getAge());
  }

  @Test
  public void personAccumulate() {
    BinaryOperator<Person> operator = (p1, p2) -> {
      p1.age += p2.getAge();
      p1.name += p2.getName();
      return p1;
    };
    Stream<Person> stream = Person.getPersonList().stream();
    Person result = stream
        .reduce(new Person("", "", 0), operator);
    assertEquals(145, result.getAge());
  }

  @Test
  public void personAgeSumCombiner() {
    BiFunction<Integer, Person, Integer> biFunction = (sum, p) -> sum += p.age;
    BinaryOperator<Integer> operator = (sum1, sum2) -> sum1 + sum2;
    Stream<Person> stream = Person.getPersonList().stream();
    Integer ageSum = stream
        .reduce(0,
            biFunction,
            operator);
    assertEquals(Integer.valueOf(145), ageSum);
  }

  @Test
  public void personAgeSumCombinerPrint() {
    Stream<Person> stream = Person.getPersonList().stream();
    BiFunction<Integer, Person, Integer> biFunction = (sum, p) -> {
      System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
      return sum += p.age;
    };
    BinaryOperator<Integer> operator = (sum1, sum2) -> {
      System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
      return sum1 + sum2;
    };
    Integer ageSum = stream
        .reduce(0,
            biFunction,
            operator);
    assertEquals(Integer.valueOf(145), ageSum);
  }

  @Test
  public void personAgeSumParallel() {
    BiFunction<Integer, Person, Integer> biFunction = (sum, p) -> {
      System.out.format("accumulator: sum=%s; person=%s\n", sum, p);
      return sum += p.age;
    };
    BinaryOperator<Integer> operator = (sum1, sum2) -> {
      System.out.format("combiner: sum1=%s; sum2=%s\n", sum1, sum2);
      return sum1 + sum2;
    };
    Stream<Person> stream = Person.getPersonList().parallelStream();
    Integer ageSum = stream
        .reduce(0, biFunction, operator);
    assertEquals(Integer.valueOf(145), ageSum);
  }

  @Test
  public void countStringLength() {
    IntBinaryOperator operator = (i1, i2) -> i1 + i2;
    Stream<String> stream = Stream.of("1", "2", "3");
    final int count = stream
        .mapToInt((String::length))
        .reduce(0, operator);
    Assert.assertEquals(3, count);
  }

  @Test
  public void countStringLengthParallel() {
    IntBinaryOperator operator = (i1, i2) -> i1 + i2;
    Stream<String> stream = Arrays.asList("1", "2", "3").parallelStream();
    final int count = stream
        .mapToInt((String::length))
        .reduce(0, operator);
    Assert.assertEquals(3, count);
  }

}
