package samples.structural.composite;

import org.junit.Test;

public class CompositeGraphicTest {
  @Test
  public void test() {
    CompositeGraphic composite = new CompositeGraphic()
        .add(new Graphic1())
        .add(new Graphic2())
        .add(new Graphic1())
        .add(
            new CompositeGraphic().add(new Graphic1())
        );
    composite.print();
  }
}
