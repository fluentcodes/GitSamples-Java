package samples.creational.builder;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import org.junit.Test;

public class FinalClassTest {
  @Test
  public void test() {
    FinalClass finalClass = new FinalBuilder()
        .setIntValue(1)
        .setDoubleValue(2.0)
        .setStringValue("test")
        .setDateValue(new Date(1L))
        .addListValues("value1", "value2")
        .addListValues("value3")
        .build();
    assertEquals("value3", finalClass.getListValue().get(2));
  }

  /**
   * Doesn't make really sense
   * TODO: Should find an example/use case to find out sense of the director.
   */
  @Test
  public void testDirector() {
    FinalClass finalClass = new FinalDirector(new FinalBuilder()
        .setIntValue(1)
        .setDoubleValue(2.0)
        .setStringValue("test")
        .setDateValue(new Date(1L))
        .addListValues("value1", "value2")
        .addListValues("value3")
    ).build();
    assertEquals("value3", finalClass.getListValue().get(2));
  }

}
