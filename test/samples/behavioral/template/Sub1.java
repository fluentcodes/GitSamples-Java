package samples.behavioral.template;

public class Sub1 extends AbstractSuper {

    @Override
    public void hello() {
      System.out.println("Hi");
      System.out.println(hookAbstract());
      System.out.println(hookConcrete());
    }

    @Override
    public String hookAbstract() {
      return "hookAbstract from " + this.getClass().getSimpleName();
    }
}
