package samples.behavioral.template;

public class Sub2 extends AbstractSuper {
  @Override
  public void hello() {
    System.out.println("Hello");
    System.out.println(hookAbstract());
    System.out.println(hookConcrete());
  }

  @Override
  String hookAbstract() {
    return "hookAbstract from " + this.getClass().getSimpleName();
  }

  @Override
  String hookConcrete() {
    return "Overwritten hookConcrete from " + this.getClass().getSimpleName();
  }
}
