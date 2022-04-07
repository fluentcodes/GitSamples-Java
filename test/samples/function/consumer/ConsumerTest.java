package samples.function.consumer;

import static samples.function.ComparatorTest.ROLES;

import java.util.function.Consumer;
import org.junit.Test;

/**
 * @author Charles Ohene
 */
public class ConsumerTest {
    static <T> void staticMethod(T t ){
        System.out.println("Personal static accepted "+t);
    }

    <T> void objectsMethod(T t ){
        System.out.println("Personal Instance accepted "+t);
    }

    @Test
    public void main() {
        Consumer<String> consumer = name -> System.out.println("LambdaName = " + name);
        ROLES.forEach(consumer);
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