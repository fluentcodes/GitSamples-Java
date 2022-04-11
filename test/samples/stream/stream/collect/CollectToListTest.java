package samples.stream.stream.collect;

import static org.junit.Assert.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
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

    @Test
    public void testCollect() throws Exception {
        Stream<String> stream = Arrays.asList("A", "B", "C").stream();
        final Collection<Integer> result =
            stream
                .map(String::length)
                .collect(
                    ArrayList<Integer>::new,
                    List::add,
                    List::addAll);
        assertEquals("[1, 1, 1]", result.toString());
    }

    @Test(expected = NullPointerException.class)
    public void containsNull_sorted_NullPointerException() {
        Stream<String> stream = Arrays.asList("A", null, "B").stream();
        stream
            .sorted()
            .collect(Collectors.toList());
    }

    @Test
    public void containsNull() {
        Stream<String> stream = Arrays.asList("A", null, "B").stream();
        assertEquals(Arrays.asList("A", null, "B"),
            stream
                .collect(Collectors.toList())
        );
    }
}
