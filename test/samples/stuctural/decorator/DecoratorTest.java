package samples.stuctural.decorator;

import org.junit.Test;

public class DecoratorTest {
  @Test
  public void testDecoration() {
    new Decorator(new DecoratedObject()).describe();
  }

  @Test
  public void testFirstDecoration() {
    new FirstDecorator(new DecoratedObject()).describe();
  }

  @Test
  public void testSecondDecoration() {
    new SecondDecorator(new DecoratedObject()).describe();
  }

  @Test
  public void testThirdDecorator() {
    new ThirdDecorator(new DecoratedObject()).describe();
  }

  @Test
  public void testChainedDecorator() {
    new ThirdDecorator(
        new SecondDecorator(
            new FirstDecorator(new DecoratedObject())
        )
    ).describe();
  }

  @Test
  public void testRandomDecorator() {
    new ThirdDecorator(
        new SecondDecorator(
            new FirstDecorator(
                new SecondDecorator(new DecoratedObject())
            )
        )
    ).describe();
  }
}

