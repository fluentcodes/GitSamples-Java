package samples.behavioral.command.file;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextFileOperationTest {

  private static TextFile textFile = new TextFile("file1.txt");

  @Test
  public void test() {
    TextFileOperation operation = new TextFileOperationSave(textFile);
    assertEquals("Saving file file1.txt", operation.execute());
  }
}
