package samples.utilStream;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import org.junit.Test;

public class ForeachTest {
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
