package samples.creational.builder;

import java.util.Date;

public class FinalDirector {
  final FinalBuilder builder;

  public FinalDirector(FinalBuilder builder) {
    this.builder = builder;
  }

  public void setDefault() {
    builder.setIntValue(1)
        .setDoubleValue(2.0)
        .setStringValue("test")
        .setDateValue(new Date(1L))
        .addListValues("value1", "value2")
        .addListValues("value3");
  }

  public FinalClass build() {
    return builder.build();
  }
}
