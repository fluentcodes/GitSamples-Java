package samples.functional.bi_function;

import org.junit.Before;
import org.junit.Test;

import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiFunction;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

public class MapComputeTest {
  Map<Integer, String> hashMap = new HashMap<>();
  @Before
  public void init() {
    hashMap.put(7, "Peter");
    hashMap.put(5, "Philip");
    hashMap.put(2, "Martin");
    hashMap.put(4, null);
    System.out.println("Initial HashMap: " + hashMap);
  }

  @Test
  public void map() {

    Map<Integer, String> map = new LinkedHashMap<>();
    map.put(1, "Java");
    map.put(2, "C++");
    map.put(3, "Java");
    BiFunction<Integer, String, String> biFunction =
        (key, value) -> "[Key=" + key + ", " + value + "(" + Collections.frequency(map.values(), value) + ")]";

    map
        .forEach(
            (a, b) -> System.out.println("test: " + biFunction.apply(a, b))
        );
  }


  @Test
  public void compute() {
    String defaultUser = "Anonymous";
    BiFunction<Integer, String, String> upperCase = (key, oldValue) -> oldValue == null ? defaultUser
        : oldValue.toUpperCase();

    hashMap.compute(2, upperCase);
    assertEquals("MARTIN", hashMap.get(2));

    hashMap.compute(4, upperCase);
    assertEquals("Anonymous", hashMap.get(4));

    System.out.println("HashMap using compute() => " + hashMap);
  }

  @Test
  public void computeIfPresent() {
    String msg = "Hello ";
    BiFunction<Integer, String, String> f2 = (key, oldValue) -> msg + oldValue + "!";

    hashMap.computeIfPresent(7, f2);
    assertEquals("Hello Peter!", hashMap.get(7));

    hashMap.computeIfPresent(3, f2);
    assertNull(hashMap.get(3));
    System.out.println("HashMap using computeIfPresent() => " + hashMap);
  }

}