package samples.creational.builder;

import java.util.Date;
import java.util.List;

public class FinalClass {
  final int intValue;
  final double doubleValue;
  final String stringValue;
  final Date dateValue;
  final List<String> listValue;

  public FinalClass(FinalBuilder builder) {
    this.intValue = builder.getIntValue();
    this.doubleValue = builder.getDoubleValue();
    this.dateValue = builder.getDateValue();
    this.stringValue = builder.getStringValue();
    this.listValue = builder.getListValue();
  }

  public int getIntValue() {
    return intValue;
  }

  public double getDoubleValue() {
    return doubleValue;
  }

  public String getStringValue() {
    return stringValue;
  }

  public Date getDateValue() {
    return dateValue;
  }

  public List<String> getListValue() {
    return listValue;
  }
}
