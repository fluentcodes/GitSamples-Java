package samples.behavioral.chainofresponsibility.logger;

import static samples.behavioral.chainofresponsibility.logger.Logger.consoleLogger;
import static samples.behavioral.chainofresponsibility.logger.Logger.emailLogger;
import static samples.behavioral.chainofresponsibility.logger.Logger.fileLogger;

import org.junit.Test;

public class LoggerTest {
  @Test
  public void testLogger() {
    // Build an immutable chain of responsibility
    Logger logger = consoleLogger(LogLevel.all())
        .appendNext(emailLogger(LogLevel.FUNCTIONAL_MESSAGE, LogLevel.FUNCTIONAL_ERROR))
        .appendNext(fileLogger(LogLevel.WARNING, LogLevel.ERROR));

    // Handled by consoleLogger since the console has a LogLevel of all
    logger.message("Entering function ProcessOrder().", LogLevel.DEBUG);
    logger.message("Order record retrieved.", LogLevel.INFO);

    // Handled by consoleLogger and emailLogger since emailLogger implements Functional_Error & Functional_Message
    logger.message("Unable to Process Order ORD1 Dated D1 For Customer C1.", LogLevel.FUNCTIONAL_ERROR);
    logger.message("Order Dispatched.", LogLevel.FUNCTIONAL_MESSAGE);

    // Handled by consoleLogger and fileLogger since fileLogger implements Warning & Error
    logger.message("Customer Address details missing in Branch DataBase.", LogLevel.WARNING);
    logger.message("Customer Address details missing in Organization DataBase.", LogLevel.ERROR);
  }
}
