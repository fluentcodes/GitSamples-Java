package samples.structural.facade;

import samples.structural.facade.strangepath.Menu4;

/**
 * Decoupling method calls within different classes. Centralize calls in facade methods. 
 */
public class MenuFacade {
  public void showMenue1() {
    new Menu1().show1();
  }
  public void showMenue2() {
    new Menu2().show2();
  }
  public void showMenue3() {
    new Menu3().show3();
  }
  public void showMenue4() {
    new Menu4().show4();
  }
}
