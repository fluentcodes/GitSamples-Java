package samples.stuctural.composite;

import java.util.ArrayList;
import java.util.List;

public class CompositeGraphic implements Graphic {
  private List<Graphic> childGraphics = new ArrayList<Graphic>();

  //Prints the graphic.
  @Override
  public void print() {
    for (Graphic graphic : childGraphics) {
      graphic.print();
    }
  }
  public CompositeGraphic add(Graphic graphic) {
    childGraphics.add(graphic);
    return this;
  }

  public void remove(Graphic graphic) {
    childGraphics.remove(graphic);
  }
}
