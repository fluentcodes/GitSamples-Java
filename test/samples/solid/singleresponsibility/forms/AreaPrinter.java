package samples.solid.singleresponsibility.forms;

public class AreaPrinter{
  final AreaCalculator calulator;
  public AreaPrinter(AreaCalculator calulator) {
    this.calulator = calulator;
  }

  public void printOut() {
     System.out.println(calulator.toString());
  }
}
