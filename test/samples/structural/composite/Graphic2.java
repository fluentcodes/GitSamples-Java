package samples.structural.composite;

public class Graphic2 implements Graphic{
  @Override
  public void print() {
    System.out.println(this.getClass().getSimpleName());
  }
}
