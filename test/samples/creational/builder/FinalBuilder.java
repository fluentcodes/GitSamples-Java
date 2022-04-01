package samples.creational.builder;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class FinalBuilder {
  private int intValue;
  private double doubleValue;
  private String stringValue;
  private Date dateValue;
  private List<String> listValue = new ArrayList<>();

  public FinalClass build() {
    return new FinalClass(this);
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

  public FinalBuilder setIntValue(int intValue) {
    this.intValue = intValue;
    return this;
  }

  public FinalBuilder setDoubleValue(double doubleValue) {
    this.doubleValue = doubleValue;
    return this;
  }

  public FinalBuilder setStringValue(String stringValue) {
    this.stringValue = stringValue;
    return this;
  }

  public FinalBuilder setDateValue(Date dateValue) {
    this.dateValue = dateValue;
    return this;
  }

  public FinalBuilder addListValues(String... listValues) {
    this.listValue.addAll(Arrays.asList(listValues));
    return this;
  }
}
