package samples.behavioral.bridge.accountbalance;

public class AbstractAccount {
  private Feedback logger = Feedback.info();

  public void setLogger(Feedback logger) {
    this.logger = logger;
  }

  // the logging part is delegated to the Logger implementation
  protected void operate(String message, boolean result) {
    logger.log(message + " result=" + result);
  }
}
