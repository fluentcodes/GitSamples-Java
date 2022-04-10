package samples.stream.collect;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.StringJoiner;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import org.junit.Test;
import samples.models.Person;

public class CollectToListTest {
    @Test
    public void collector() {
        Stream <Person> stream = Person.getPersonList().stream();
        List<Person> filtered = stream
                .filter(p -> p.getName().startsWith("c"))
                .collect(Collectors.toList());

        assertEquals("chen/peking (22)", filtered.get(0).toString());
    }
}
