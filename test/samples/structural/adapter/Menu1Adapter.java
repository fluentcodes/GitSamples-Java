package samples.structural.adapter;

public class Menu1Adapter implements MenuAdapter{
  @Override
  public void show() {
    new Menu1().show1();
  }
}
