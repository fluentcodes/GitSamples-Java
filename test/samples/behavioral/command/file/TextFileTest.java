package samples.behavioral.command.file;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class TextFileTest {

  private static TextFile textFile = new TextFile("file1.txt");

  @Test
  public void testOpen() {
    assertEquals("Opening file file1.txt", textFile.open());
  }

  @Test
  public void testWrite() {
    assertEquals("Writing to file file1.txt", textFile.write());
  }

  @Test
  public void testSave() {
    assertEquals("Saving file file1.txt", textFile.save());
  }

  @Test
  public void testCopy() {
    assertEquals("Copying file file1.txt", textFile.copy());
  }

  @Test
  public void testPaste() {
    assertEquals("Pasting file file1.txt", textFile.paste());
  }

  @Test
  public void test() {
    TextFileOperation openTextFileOperation = new TextFileOperationSave(new TextFile("file1.txt"));
    assertEquals("Saving file file1.txt", openTextFileOperation.execute());
  }
}
