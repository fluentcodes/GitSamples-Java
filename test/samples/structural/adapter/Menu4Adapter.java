package samples.structural.adapter;

import samples.structural.facade.strangepath.Menu4;

public class Menu4Adapter implements MenuAdapter{
  @Override
  public void show() {
    new Menu4().show4();
  }
}
