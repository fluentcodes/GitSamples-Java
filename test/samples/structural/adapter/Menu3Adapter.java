package samples.structural.adapter;

public class Menu3Adapter implements MenuAdapter{
  @Override
  public void show() {
    new Menu3().show3();
  }
}
