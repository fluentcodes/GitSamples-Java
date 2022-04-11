package samples.stream.stream.examples.enemenemu;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class EneMeneMuhTest {
    final static List<String> STRING_LIST = Arrays.asList("ene", "mene", "muh", "und", "raus", "bist", "du");

    final static SomeClass[]
        EXPECTED = { SomeClass.ene(), SomeClass.mene(), SomeClass.muh(), SomeClass.und(), SomeClass.raus(), SomeClass.bist(), SomeClass.du() };

    @Test
    public void testConstructor() {
        final SomeClass[] eneMeneLambda = STRING_LIST
            .stream()
            .map(s -> new SomeClass(s))
            .toArray(n -> new SomeClass[n]);
        Assert.assertArrayEquals(EXPECTED, eneMeneLambda);
    }

    @Test
    public void testConstructorRef() {
        final SomeClass[] eneMeneMethodRef = STRING_LIST.stream()
            .map(SomeClass::new)
            .toArray(SomeClass[]::new);
        Assert.assertArrayEquals(EXPECTED, eneMeneMethodRef);
    }


}
