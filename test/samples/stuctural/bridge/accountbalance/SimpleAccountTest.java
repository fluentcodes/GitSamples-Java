package samples.stuctural.bridge.accountbalance;

import org.junit.Test;

public class SimpleAccountTest {
  @Test
  public void testBridge() {
    SimpleAccount account = new SimpleAccount(100);
    account.withdraw(75);

    if (account.isBalanceLow()) {
      // you can also change the Logger implementation at runtime
      account.setLogger(Feedback.warning());
    }

    account.withdraw(10);
    account.withdraw(100);
  }
}
