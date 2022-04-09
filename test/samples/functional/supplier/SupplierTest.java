package samples.functional.supplier;

import org.junit.Test;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Random;
import java.util.function.Supplier;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class SupplierTest {

    @Test
    public void test() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

        Supplier<LocalDateTime> s = () -> LocalDateTime.now();
        LocalDateTime time = s.get();

        System.out.println(time);

        Supplier<String> s1 = () -> dtf.format(LocalDateTime.now());
        String time2 = s1.get();

        System.out.println(time2);
    }

    @Test
    public void intRandom() {
        Supplier<Object> supplier = () -> new Random().nextInt(10);
        print(supplier);
    }

    @Test
    public void doubleRandom() {
        Supplier<Object> supplier = () -> Math.random();
        print(supplier);
    }

    void print(Supplier<Object> supplier) {
        System.out.println("Generic print of supplier value: " + supplier.get());
    }

    @Test
    public void testFactory() {
        Supplier<Developer> supplier = Developer::new;
        assertNull(
            factory(supplier).getName());
    }

    @Test
    public void testFactorySet() {
        Supplier<Developer> supplier = () -> new Developer("fluentcodes");
        assertEquals("fluentcodes",
            factory(supplier).getName());

    }

    public static Developer factory(Supplier<? extends Developer> s) {
        return  s.get();
    }

}