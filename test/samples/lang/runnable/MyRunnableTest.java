package samples.lang.runnable;

import org.junit.Test;
import samples.lang.runnable.MyRunnable;

public class MyRunnableTest {
  @Test
  public void lambda() {
    Runnable runnable =
        () -> {
          for (int i = 0; i < 5; i++) {
            System.out
                .println("Runnable " + Thread.currentThread().getName() + ": " + i);
          }
    };
    Thread thread1 = new Thread(runnable, "Thread 1");
    thread1.start();
    Thread thread2 = new Thread(runnable, "Thread 2");
    thread2.start();
  }

  @Test
  public void lambdaNotMixed() {
    Runnable runnable =
        () -> {
          for (int i = 0; i < 5; i++) {
            System.out
                .println("Runnable " + Thread.currentThread().getName() + ": " + i);
          }
        };
    new Thread(runnable, "Thread 1").start();
    new Thread(runnable, "Thread 2").start();
  }

  @Test
  public void init() {
    new MyRunnable().run();
  }

  @Test
  public void test() {
    System.out.println("Executing program...");
   MyRunnable runnable = new MyRunnable();
    Thread thread1 = new Thread(runnable, "Thread 1");
    thread1.start();
    Thread thread2 = new Thread(runnable, "Thread 2");
    thread2.start();
    Thread thread3 = new Thread(new Runnable() {
      @Override
      public void run() {
       for (int i = 0; i < 5; i++) {
          System.out
              .println("Runnable " + Thread.currentThread().getName() + ": " + i);
        }
      }
    }, "Thread 3");
    thread3.start();
  }
}
