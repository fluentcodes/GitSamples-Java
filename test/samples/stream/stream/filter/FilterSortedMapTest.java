package samples.stream.stream.filter;

import java.util.stream.Stream;
import org.junit.Test;

public class FilterSortedMapTest {
  @Test
  public void mapFilter() {
    System.out.println("All mapping operation will be executed. ");
    Stream.of("d2", "a2", "b1", "b3", "c")
        .map(s -> {
          System.out.println("map: " + s);
          return s.toUpperCase();
        })
        .filter(s -> {
          System.out.println("filter: " + s);
          return s.startsWith("A");
        })
        .forEach(s -> System.out.println("forEach: " + s));
  }
    @Test
    public void filterMap() {
    //map is only called once so the operation pipeline performs much faster for larger numbers of input elements.
    System.out.println("Filter in front reduces the number of subsequent operations. ");
    Stream.of("d2", "a2", "b1", "b3", "c")
        .filter(s -> {
          System.out.println("filter: " + s);
          return s.startsWith("a");
        })
        .map(s -> {
          System.out.println("map: " + s);
          return s.toUpperCase();
        })
        .forEach(s -> System.out.println("forEach: " + s));
    }
  @Test
  public void mapSortedFilter() {
    //First, the sort operation is executed on the entire input collection. In other words sorted is executed horizontally. So in this case sorted is called eight times for multiple combinations on every element in the input collection.
    System.out.println("With unoptimized sort operation");
    Stream.of("d2", "a2", "a1", "b1", "b3", "c")
        .map(s -> {
          System.out.println("map: " + s);
          return s.toUpperCase();
        })
        .sorted((s1, s2) -> {
          System.out.printf("sort: %s; %s\n", s1, s2);
          return s1.compareTo(s2);
        })
        .filter(s -> {
          System.out.println("filter: " + s);
          return s.startsWith("a");
        })
        .forEach(s -> System.out.println("forEach: " + s));

  }
  @Test
  public void filterSortedMap() {
    System.out.println("Optimize the performance by reordering the chain:");
    Stream.of("d2", "a2", "a1", "b1", "b3", "c")
        .filter(s -> {
          System.out.println("filter: " + s);
          return s.startsWith("a");
        })
        .sorted((s1, s2) -> {
          System.out.printf("sort: %s; %s\n", s1, s2);
          return s1.compareTo(s2);
        })
        .map(s -> {
          System.out.println("map: " + s);
          return s.toUpperCase();
        })
        .forEach(s -> System.out.println("forEach: " + s));
  }
}
