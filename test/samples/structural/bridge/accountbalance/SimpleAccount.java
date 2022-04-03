package samples.structural.bridge.accountbalance;

public class SimpleAccount extends AbstractAccount {
  private int balance;

  public SimpleAccount(int balance) {
    this.balance = balance;
  }

  public boolean isBalanceLow() {
    return balance < 50;
  }

  public void withdraw(int amount) {
    if (balance >= amount) {
      balance -= amount;
    }
    operate("withdraw " + amount, balance >= amount);
  }
}
