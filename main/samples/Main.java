package samples;

public class Main {
  public static void main(String... args) {
    int counter=0;
    System.out.println(counter + " Start.");
    for (String arg:args) {
      System.out.println("argument=" + arg);
      counter++;
    }
  }
}
