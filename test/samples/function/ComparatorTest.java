package samples.function;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import org.junit.Test;

public class ComparatorTest {
  public static List ROLES = Arrays.asList("Joe", "Der Großvater", "Peter Pan", "Heidi");

  @Test
  public void sortClassical() {
    final Comparator<String> COMPARATOR_LENGTH = new Comparator<String>() {
      @Override
      public int compare(String s1, String s2) {
        return s1.length() - s2.length();
      }
    };
    Collections.sort(ROLES, COMPARATOR_LENGTH);
    System.out.println("By Length: " + ROLES);
  }

  @Test
  public void comparatorFullyTypedTyped() {
    Comparator<String> comparator = (String s1, String s2) -> {
      return s1.compareTo(s2);
    };

    Collections.sort(ROLES, comparator);
    System.out.println("ConsumerTyped: " + ROLES);
  }

  @Test
  public void comparatorImplicitTyped() {
    // Kürzere Alternative: Ohne Parametertyp
    Comparator<String> compLambdaLexiko2 = (s1, s2) -> {
      return s1.compareTo(s2);
    };
    Collections.sort(ROLES, compLambdaLexiko2);
    System.out.println("ConsumerTyped: " + ROLES);
  }

  /**
   * Short alternative without return and brackets
   */
  @Test
  public void comparatorImplicitReturn() {
    Comparator<String> compLambdaLexiko3 = (s1, s2) -> s1.compareTo(s2);
    Collections.sort(ROLES, compLambdaLexiko3);
    System.out.println("Consumer Untyped: " + ROLES);
  }

  /**
   * Use List.sort method from Java8
   */
  @Test
  public void sortListMethod() {
    Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
    ROLES.sort(comparator);
  }
}