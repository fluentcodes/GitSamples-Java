package samples.functional.consumer;

import java.util.stream.Stream;
import org.junit.Test;

import java.util.function.Consumer;

import static samples.functional.ComparatorTest.ROLES;

public class ConsumerTest {
    static <T> void staticMethod(T t) {
        System.out.println("Personal static accepted " + t);
    }

    <T> void objectsMethod(T t) {
        System.out.println("Personal Instance accepted " + t);
    }

    @Test
    public void test() {
        Consumer<String> consumer = name -> System.out.println("LambdaName = " + name);
        ROLES.forEach(consumer);
    }

    @Test
    public void andThen() {
        final Consumer<String> consumer1 = s -> System.out.println("1. " + s);
        final Consumer<String> consumer2 = s -> System.out.println("2. " + s);
        final Consumer<String> chained = consumer1.andThen(consumer2);
        Stream<String> stream = Stream.of("A", "B");
        stream
            .forEach(chained);

    }
    @Test
    public void andThenCasted() {
        Stream<String> stream = Stream.of("A", "B");
       stream
            .forEach(
                ((Consumer<String>)(s -> System.out.println("1. " + s)))
                .andThen(s -> System.out.println("2. " + s))
            );
    }

    /* Method reference expects a Consumer, returning void. Each element should be fulfill the Consumer.accept method.
     */
    @Test
    public void methodReference() {
        Consumer<String> consumer = System.out::println;
        ROLES.forEach(consumer);
    }

    @Test
    public void methodReferenceStatic() {
        Consumer<String> consumer = ConsumerTest::staticMethod;
        ROLES.forEach(consumer);
    }

    @Test
    public void methodReferenceFromObject() {
        //Beispiel einer eigenen Objekt-MethodenReferenz
        ConsumerTest myObj = new ConsumerTest();
        Consumer<String> consumer = myObj::objectsMethod;
        ROLES.forEach(consumer);
    }
}