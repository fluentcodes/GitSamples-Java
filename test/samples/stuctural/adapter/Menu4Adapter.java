package samples.stuctural.adapter;

import samples.stuctural.facade.strangepath.Menu4;

public class Menu4Adapter implements MenuAdapter{
  @Override
  public void show() {
    new Menu4().show4();
  }
}
