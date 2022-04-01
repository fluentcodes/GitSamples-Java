package samples.stuctural.facade;

public class Menu1 implements Menu{
  @Override
  public void show() {
    System.out.println(this.getClass().getSimpleName());
  }
}
