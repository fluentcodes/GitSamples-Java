package samples.behavioral.visitor.car;

public final class Engine implements CarElement {
  public void accept(final CarElementVisitor visitor) {
    visitor.visit(this);
  }
}
