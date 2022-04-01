package samples.stuctural.composite;

public class Graphic1 implements Graphic{
  @Override
  public void print() {
    System.out.println(this.getClass().getSimpleName());
  }
}
