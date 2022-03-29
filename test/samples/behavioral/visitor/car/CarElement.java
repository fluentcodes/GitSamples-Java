package samples.behavioral.visitor.car;

public interface CarElement {
  void accept(CarElementVisitor visitor);
}
