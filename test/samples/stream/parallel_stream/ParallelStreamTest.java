package samples.stream.parallel_stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;
import samples.models.Person;

public class ParallelStreamTest {

    static final List<String> NAMES = Arrays.asList("Stefan", "Ralph", "Andi");

    @Test
    public void print() {
        Stream<String> stream = NAMES.parallelStream();
        stream.forEach(System.out::println);
    }

    @Test
    public void sortedDoesNotWork() {
        NAMES.parallelStream()
            .sorted()
            .forEach(System.out::println);
    }

    @Test
    public void sortedForEachOrdered() {
         NAMES.parallelStream()
             .sorted()
             .forEachOrdered(System.out::println);
    }

    @Test
    public void testParallel() {
        System.out.println("Write out what happened: ");
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
            .parallelStream()
            .filter(s -> {
                System.out.format("filter: %s [%s]\n",
                    s, Thread.currentThread().getName());
                return true;
            })
            .map(s -> {
                System.out.format("map: %s [%s]\n",
                    s, Thread.currentThread().getName());
                return s.toUpperCase();
            })
            .forEach(s -> System.out.format("forEach: %s [%s]\n",
                s, Thread.currentThread().getName()));

    }
    @Test
    public void testParallelWithSort() {
        System.out.println("Write out what happened: Sort will always be in the main thread.");
        Arrays.asList("a1", "a2", "b1", "c2", "c1")
            .parallelStream()
            .filter(s -> {
                System.out.format("filter: %s [%s]\n",
                    s, Thread.currentThread().getName());
                return true;
            })
            .map(s -> {
                System.out.format("map: %s [%s]\n",
                    s, Thread.currentThread().getName());
                return s.toUpperCase();
            })
            .sorted((s1, s2) -> {
                System.out.format("sort: %s <> %s [%s]\n",
                    s1, s2, Thread.currentThread().getName());
                return s1.compareTo(s2);
            })
            .forEach(s -> System.out.format("forEach: %s [%s]\n",
                s, Thread.currentThread().getName()));

    }

    @Test
    public void testParallelReducePerson () {
        System.out.println("Now reducing with parallel stream:");
        Person.getPersonList()
            .parallelStream()
            .reduce(0,
                (sum, p) -> {
                    System.out.format("accumulator: sum=%s; person=%s [%s]\n",
                        sum, p, Thread.currentThread().getName());
                    return sum += p.age;
                },
                (sum1, sum2) -> {
                    System.out.format("combiner: sum1=%s; sum2=%s [%s]\n",
                        sum1, sum2, Thread.currentThread().getName());
                    return sum1 + sum2;
                });
    }
}
