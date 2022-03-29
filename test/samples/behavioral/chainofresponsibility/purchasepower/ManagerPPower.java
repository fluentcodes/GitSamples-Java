package samples.behavioral.chainofresponsibility.purchasepower;

public class ManagerPPower extends PurchasePower {

  protected double getAllowable() {
    return BASE * 10;
  }

  protected String getRole() {
    return "Manager";
  }
}
