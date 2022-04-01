package samples.stuctural.facade;

import org.junit.Test;

public class MenuFacadeTest {
  @Test
  public void test() {
    new MenuFacade().showMenue1();
    new MenuFacade().showMenue2();
    new MenuFacade().showMenue3();
    new MenuFacade().showMenue4();
  }
}
