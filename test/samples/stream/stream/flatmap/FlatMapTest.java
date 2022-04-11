package samples.stream.stream.flatmap;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.IntStream;
import org.junit.Test;
public class FlatMapTest {
    @Test
    public void testFlatMap() {
        List<Foo> foos = new ArrayList<>();

        System.out.println("Creating 3 foos with 3 bars each");
        //----
        // create foos
        IntStream
            .range(1, 4)
            .forEach(i -> foos.add(new Foo("Foo" + i)));

        // create bars
        foos.forEach(f ->
            IntStream
                .range(1, 4)
                .forEach(i -> f.bars.add(new Bar("Bar" + i + " <- " + f.name))));

        System.out.println("Now streaming foos with all bars within: ");
        //---
        foos.stream()
            .flatMap(f -> f.bars.stream())
            .forEach(b -> System.out.println(b.name));
    }

    @Test
    public void singlePipline() {
        System.out.println("Concating to a single pipeline:");
        Consumer<Foo>  consumer = f -> IntStream.range(1, 4)
            .mapToObj(i -> new Bar("Bar" + i + " <- " + f.name))
            .forEach(f.bars::add);
        IntStream.range(1, 4)
            .mapToObj(i -> new Foo("Foo" + i))
            .peek(consumer)
            .flatMap(f -> f.bars.stream())
            .forEach(b -> System.out.println(b.name));
    }

    class Foo {
        String name;
        List<Bar> bars = new ArrayList<>();

        Foo(String name) {
            this.name = name;
        }
    }

    class Bar {
        String name;

        Bar(String name) {
            this.name = name;
        }
    }

}
