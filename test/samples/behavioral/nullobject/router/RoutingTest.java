package samples.behavioral.nullobject.router;

import java.util.Arrays;
import java.util.List;
import org.junit.Test;

public class RoutingTest {

  @Test
  public void test() {
    Message highPriorityMsg = new Message("Alert!", "high");
    Message mediumPriorityMsg = new Message("Warning!", "medium");
    Message lowPriorityMsg = new Message("Take a look!", "low");
    Message nullPriorityMsg = new Message("Take a look!", null);

    List<Message> messages = Arrays.asList(highPriorityMsg,
        mediumPriorityMsg,
        lowPriorityMsg,
        nullPriorityMsg);

    RoutingHandler routingHandler = new RoutingHandler();
    routingHandler.handle(messages);
  }
}
