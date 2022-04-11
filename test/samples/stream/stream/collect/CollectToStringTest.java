package samples.stream.stream.collect;

import static java.util.stream.Collectors.groupingBy;
import static org.junit.Assert.assertEquals;

import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import samples.models.Person;

public class CollectToStringTest {
    @Test
    public void collector() {
        Stream <Person> stream = Person.getPersonList().stream();

        //BiFunction<String, StringJoiner , String> combiner = (s1, s2) -> s1.merge(s2);
        //BinaryOperator<String> combi
        //
        //BiFunction<StringJoiner, Person, StringJoiner> combiner =  (j, p) -> j.add(p.getName().toUpperCase());
        //Function<Person, String> functionName = p -> p.getName();
        //BinaryOperator<String> operator = (name1, name2) -> name1 + ";" + name2;
        Collector<Person, StringJoiner, String> collector =
            Collector.of(
                () -> new StringJoiner(" | "),          // supplier
                (j, p) -> j.add(p.getName().toUpperCase()),  // accumulator
                (j1, j2) -> j1.merge(j2),               // combiner
                StringJoiner::toString);                // finisher

        String result = stream
            .collect(
                collector
            );

        assertEquals("WALTER | CHEN | SING | CHRISTIAN | CHRISTIAN | CHRISTIAN", result);
    }

    @Test
    public void joining() {
        Stream <Person> stream = Person.getPersonList().stream();
         String result = stream
            .filter(p -> p.getAge() >= 18)
            .map(p -> p.getName())
            .collect(Collectors.joining(" and ", "In Germany ", " are of legal age."));
        ;

        assertEquals("In Germany chen and sing and christian and christian are of legal age.", result);
    }
}
