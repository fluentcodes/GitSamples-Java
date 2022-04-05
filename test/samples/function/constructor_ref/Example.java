package samples.function.constructor_ref;

import java.util.List;

public class Example {

  private String content;

  private List<String> list;

  public Example() {
    this.content = "created by constructor reference";
    System.out.println("ConstructorReference.DefaultConstructor finished.");
  }

  public Example(String content) {
    this.content = content;
  }

  public Example(List<String> contents) {
    this.list = contents;
  }

  public String getContent() {
    return content;
  }

  public List<String> getList() {
    return list;
  }
}
