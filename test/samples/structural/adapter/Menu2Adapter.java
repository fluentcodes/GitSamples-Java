package samples.structural.adapter;

public class Menu2Adapter implements MenuAdapter{
  @Override
  public void show() {
    new Menu2().show2();
  }
}
