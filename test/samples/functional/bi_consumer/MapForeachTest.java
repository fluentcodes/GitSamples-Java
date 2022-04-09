package samples.functional.bi_consumer;

import org.junit.Test;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.function.BiConsumer;

public class MapForeachTest {
  @Test
  public void map() {
    BiConsumer<Integer, String> biConsumer = (k, v) -> System.out.println(k + ":" + v);
    Map<Integer, String> map = new LinkedHashMap<>();
    map.put(1, "Java");
    map.put(2, "C++");
    map.put(3, "Rust");
    map.put(4, "JavaScript");
    map.put(5, "Go");

    map.forEach(biConsumer);
  }

}