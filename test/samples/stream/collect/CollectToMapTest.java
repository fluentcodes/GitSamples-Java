package samples.stream.collect;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import samples.models.Person;

public class CollectToMapTest {
    @Test
    public void groupingByLength() {
        Stream<String> stream = Stream.of("Stefan", "Ralph", "Andi");
        Function<String, Integer> function = String::length;
        Map<Integer, List<String>> mapByLength = stream
            .collect(groupingBy(function));
        assertEquals("Andi", mapByLength.get(4).get(0));
    }

    @Test
    public void partitioningByLengthGreater4() {
        Stream<String> stream = Stream.of("Stefan", "Ralph", "Andi");
        Predicate<String> predicate = str -> str.length() > 4;
        Map<Boolean, List<String>> mapGreater4 = stream
            .collect(Collectors.partitioningBy(predicate));
        assertEquals("Andi", mapGreater4.get(false).get(0));
    }

    @Test
    public void groupingPersonByAge() {
        Stream<Person> stream = Person.getPersonList().stream();
        Function<Person, Integer> function = p -> p.getAge();
        Map<Integer, List<Person>> personsByAge = stream
            .collect(
                Collectors.groupingBy(function)
            );

        assertEquals(42, personsByAge.get(42).get(0).getAge());
    }

    @Test
    public void groupingByPersonCity() {
        Function<Person, String> functionCity = Person::getCity;

        Stream<Person> stream = Person.getPersonList().stream();

        Map<String, List<Person>> collect = stream
            .collect(
                Collectors.groupingBy(functionCity)
            );

        assertEquals("christian", collect.get("munich").get(0).getName());
    }

    @Test
    public void groupingByPersonCityNameSet() {
        Function<Person, String> functionCity = p -> p.getCity();
        Function<Person, String> functionName = Person::getName;

        Stream<Person> stream = Person.getPersonList().stream();

        Map<String, Set<String>> collect = stream
            .collect(
                Collectors.groupingBy(
                    functionCity,
                    Collectors.mapping(functionName, Collectors.toSet())
                )
            );
        assertEquals(1, collect.get("munich").size());
    }

    @Test
    public void groupingByPersonCityNameList() {
        Function<Person, String> functionCity = p -> p.getCity();
        Function<Person, String> functionName = Person::getName;

        Stream<Person> stream = Person.getPersonList().stream();

        Map<String, List<String>> collect = stream
            .collect(
                Collectors
                    .groupingBy(functionCity,
                        Collectors.mapping(functionName, Collectors.toList())
                    )
            );
        assertEquals(2, collect.get("munich").size());
        assertEquals("christian", collect.get("munich").get(0));
    }

    @Test
    public void toMapPersonByAge() {
        Stream<Person> stream = Person.getPersonList().stream();
        Function<Person, Integer> function = p -> p.getAge();
        Function<Person, String> functionName = p -> p.getName();
        BinaryOperator<String> operator = (name1, name2) -> name1 + ";" + name2;
        Map<Integer, String> personsByAge = stream
            .collect(
                Collectors.toMap(
                    function,
                    functionName,
                    operator)
            );

        assertEquals("sing", personsByAge.get(42));
    }

    @Test
    public void collector() {
        Stream<Person> stream = Person.getPersonList().stream();
        Function<Person, Integer> function = p -> p.getAge();
        Function<Person, String> functionName = p -> p.getName();
        BinaryOperator<String> operator = (name1, name2) -> name1 + ";" + name2;
        Map<Integer, String> personsByAge = stream
            .collect(
                Collectors.toMap(
                    function,
                    functionName,
                    operator)
            );

        assertEquals("sing", personsByAge.get(42));
    }


}
