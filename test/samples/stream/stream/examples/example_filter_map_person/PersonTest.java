package samples.stream.stream.examples.example_filter_map_person;

import static org.junit.Assert.assertEquals;

import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.OptionalDouble;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;

/**
 * Beispielprogram zeigt, wie man mit JDK 8 und Streams sowie Lambdas elegant eine Filter-Map-Reduce-Funktionalit�t implementiert.
 *
 * @author Michael Inden
 * <p>
 * Copyright 2014 by Michael Inden
 */
public class PersonTest {
    final static List<Person> PERSONS = Arrays.asList(
        new Person("Stefan", 59, LocalDate.of(1963, Month.MAY, 12)),
        new Person("Micha", 17, LocalDate.of(2005, Month.FEBRUARY, 7)),
        new Person("Andi", 10, LocalDate.of(2012, Month.JULY, 17)),
        new Person("Thorben", 2 , LocalDate.of(2020, Month.JULY, 17)),
        new Person("Merten", 47, LocalDate.of(1975, Month.JUNE, 14)));

    @Test
    public void stream() {
        final String bornInJuly = PERSONS.stream()
            .filter(person -> person.birthday.getMonth() == Month.JULY)
            .map(person -> person.name)
            .collect(Collectors.joining(", "));

        assertEquals("Andi, Andi Steffen", bornInJuly);
    }

    @Test
    public void classic()
    {
        final List<Person> bornInJuly = new ArrayList<>();
        for (final Person person : PERSONS) {
            if (person.birthday.getMonth() == Month.JULY) {
                bornInJuly.add(person);
            }
        }
        final List<String> names = new ArrayList<>();
        for (final Person person : bornInJuly) {
            names.add(person.name);
        }
        final StringBuilder sb = new StringBuilder();

        final Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }

        assertEquals("Andi, Andi Steffen", sb.toString());
    }

    @Test
    public void filterIsAdult() {
        final Stream<Person> adultPersonStream = PERSONS.stream().filter(Person::isAdult);
        final Stream<String> adultNameStream = adultPersonStream.map(person -> person.getName());
        assertEquals("Stefan,Merten", adultNameStream.collect(Collectors.joining(",")));
    }

    @Test
    public void filterAgeGreater18() {
        final Stream<Integer> ageIntegerStream = PERSONS.stream().map(Person::getAge);
        final Stream<Integer> adultIntegerStream = ageIntegerStream.filter(age -> age >= 18);

        assertEquals(Arrays.asList(59, 47), adultIntegerStream.collect(Collectors.toList()));
    }

    @Test
    public void peek() {
        System.out.println("Protokollierung jedes einzelnen Schritts");
        final Stream<Person> stream = PERSONS.stream();

        final Stream<String> startWithMStream = PERSONS.stream()
            .peek(person -> System.out.println("In: " + person))
            .filter(Person::isAdult)
            .peek(adultPerson -> System.out.println("ADULT: " + adultPerson))
            .map(Person::getName)
            .peek(name -> System.out.println("NAME: " + name))
            .filter(name -> name.startsWith("M"))
            .peek(name -> System.out.println("NAME START WITH M: " + name))
            .map(String::toUpperCase);
        assertEquals("MERTEN", startWithMStream.collect(Collectors.joining(",")));
    }

    @Test
    public void peekFunction() {
        final Function<Stream<Person>,Stream<String>> streamFunction =
            stream -> stream.filter(Person::isAdult)
                .peek(a -> System.out.println("ADULT: " + a))
                .map(Person::getName)
                .peek(name -> System.out.println("NAME: " + name))
                .filter(name -> name.startsWith("M"))
                .peek(start -> System.out.println("NAME START WITH M: " + start))
                .map(String::toUpperCase);
        Stream<String> startWithMStream = streamFunction.apply(PERSONS.stream());
        assertEquals("MERTEN", startWithMStream.collect(Collectors.joining(",")));
    }

    @Test
    public void misc() {
        // Anzahl an Personen, deren Name mit 'T' statet
        final long count = PERSONS.stream()
            .filter(person -> person.getName().startsWith("T"))
            .count();
        System.out.println("count: " + count);

        final int sum = PERSONS.stream()
            .filter(person -> person.getName().startsWith("T"))
            .mapToInt(Person::getAge)
            .sum();
        System.out.println("sum:   " + sum);

        final OptionalDouble avg = PERSONS.stream()
            .filter(person -> person.getName().startsWith("T"))
            .mapToInt(Person::getAge).average();
        System.out.println("avg:   " + avg.getAsDouble());
    }

}