package samples.optionals.flatMap;

import org.junit.Test;

import java.util.Optional;

/**
 * Created by werner/ecube on 07.08.16.
 * http://winterbe.com/posts/2014/07/31/java8-stream-tutorial-examples/
 */
public class OptionalFlatMapTest {
    @Test
    public void flatMap() {
        Outer outer = new Outer();
        System.out.println("Empty outer classical:");
        if (outer != null && outer.getNested() != null && outer.getNested().getInner() != null) {
            System.out.println(outer.getNested().getInner().getFoo());
        }
        System.out.println("Empty outer optional with flatMap:");
        Optional.of(outer)
                .flatMap(o -> Optional.ofNullable(o.getNested()))
                .flatMap(n -> Optional.ofNullable(n.getInner()))
                .flatMap(i -> Optional.ofNullable(i.getFoo()))
                .ifPresent(System.out::println);

    }
    @Test
    public void flatMapOptionalNonEmpty() {
        Outer outer = new Outer("test");
        System.out.println("Non empty outer classical:");
        if (outer != null && outer.getNested() != null && outer.getNested().getInner() != null) {
            System.out.println(outer.getNested().getInner().getFoo());
        }
        System.out.println("Non empty outer optional with flatMap:");
        Optional.of(outer)
                .flatMap(o -> Optional.ofNullable(o.getNested()))
                .flatMap(n -> Optional.ofNullable(n.getInner()))
                .flatMap(i -> Optional.ofNullable(i.getFoo()))
                .ifPresent(System.out::println);
    }

}
