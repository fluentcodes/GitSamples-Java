package samples.behavioral.state.packagedelivery;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class StateTest {

  @Test
  public void givenNewPackage_whenPackageReceived_thenStateReceived() {
    Package pkg = new Package();
    assertEquals(OrderedState.class, pkg.getState().getClass());

    pkg.nextState();
    assertEquals(DeliveredState.class, pkg.getState().getClass());

    pkg.nextState();
    assertEquals(ReceivedState.class, pkg.getState().getClass());
  }

  @Test
  public void givenDeliveredPackage_whenPrevState_thenStateOrdered() {
    Package pkg = new Package();
    pkg.setState(new DeliveredState());
    pkg.previousState();
    assertEquals(OrderedState.class, pkg.getState().getClass());
  }
}
