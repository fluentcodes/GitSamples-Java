package samples.functional.runnable;

import java.util.stream.IntStream;

public class MyRunnable implements Runnable{
  @Override
  public void run() {
    for (int i = 0; i < 5; i++) {
      System.out
          .println("Runnable " + Thread.currentThread().getName() + ": " + i);
    }
  }

  public void runNotWorking() {
    IntStream
        .range(1,10)
        .boxed()
        .forEach(i->System.out
            .println("Running " + Thread.currentThread().getName() + ": " + i ));
  }
}
