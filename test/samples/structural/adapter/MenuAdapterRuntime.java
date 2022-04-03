package samples.structural.adapter;

import samples.structural.adapter.strangepath.Menu4;

/**
 * Runtime adapter depending on class of the instance.
 */
public class MenuAdapterRuntime {
  public void show(Object menu) {
    if (menu instanceof Menu1) {
      new Menu1().show1();
    }
    else if (menu instanceof Menu2) {
      new Menu2().show2();
    }
    else if (menu instanceof Menu3) {
      new Menu3().show3();
    }
    else if (menu instanceof Menu4) {
      new Menu4().show4();
    }

  }
}
