package samples.behavioral.template;

public abstract class AbstractSuper {
  abstract void hello();

  abstract String hookAbstract();

  String hookConcrete() {
    return "hook2 in Abstract Super";
  }
}
