package samples.stuctural.facade;

public class Menu2 implements Menu{
  @Override
  public void show() {
    System.out.println(this.getClass().getSimpleName());
  }
}
