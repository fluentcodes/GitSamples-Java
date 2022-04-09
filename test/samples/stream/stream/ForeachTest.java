package samples.stream.stream;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.Test;

public class ForeachTest {
    @Test
    public void printLineVariants()
    {
        final List<String> names = Arrays.asList("A", "B");
        names.forEach((String name) -> { System.out.println(name); });
        names.forEach(name -> System.out.println(name) );
        names.forEach(System.out::println);
    }

    @Test
    public void printLineClassic(final String[] args)
    {
        final List<String> names = Arrays.asList("B", "B");
        final Iterator<String> it = names.iterator();
        while (it.hasNext()) {
            System.out.println(it.next());
        }
        for (int i = 0; i < names.size(); i++) {
            System.out.println(names.get(i));
        }
        for (final String name : names) {  // JDK 5
            System.out.println(name);
        }
    }

    // From http://www.angelikalanger.com/Articles/EffectiveJava/71.Java8.Lambdas/71.Java8.Lambdas.html
    @Test
    public void foreachList() {
        System.out.println("A Integer List with foreach and print out Lamda i -> System.out.println(i)");
        List<Integer> numbers = Arrays.asList(new Integer[]{0,1,2});
        numbers.forEach( i -> System.out.println(i) );

        System.out.println("A Object List with foreach and print out Lamda i -> System.out.println(i)");
        List objects = Arrays.asList(new Object[]{0,1.1,"2S"});
        objects.forEach( i -> System.out.println(i) );

        System.out.println("A Object List with foreach and print out Lamda (i) -> System.out.println(i)");
        objects.forEach( (i) -> System.out.println(i) );

        System.out.println("A Object List with foreach and print out Lamda object reference 'System.out :: println':");
        objects.forEach( System.out :: println );
    }
}
