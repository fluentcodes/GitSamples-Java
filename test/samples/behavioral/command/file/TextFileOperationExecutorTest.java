package samples.behavioral.command.file;

import static org.junit.Assert.assertEquals;

import java.util.function.Function;
import org.junit.Test;

public class TextFileOperationExecutorTest {

  private static TextFileOperationExecutor textFileOperationExecutor = new TextFileOperationExecutor();

  @Test
  public void testOpenTextFileOperation() {
    TextFileOperation operation = new TextFileOperationOpen(new TextFile("file1.txt"));
    assertEquals("Opening file file1.txt",
        textFileOperationExecutor.executeOperation(operation));
  }

  @Test
  public void testSaveTextFileOperation() {
    TextFileOperation operation = new TextFileOperationSave(new TextFile("file1.txt"));
    assertEquals("Saving file file1.txt",
        textFileOperationExecutor.executeOperation(operation));
  }

  @Test
  public void testOpenLambda() {
    assertEquals("Opening file file1.txt",
        textFileOperationExecutor.executeOperation(() -> {
          return "Opening file file1.txt";
        }));
  }

  @Test
  public void testSaveOpenLambda() {
    assertEquals("Saving file file1.txt",
        textFileOperationExecutor.executeOperation(() -> {
          return "Saving file file1.txt";
        }));
  }

  @Test
  public void testOpenMethodReference() {
    TextFile textFile = new TextFile("file1.txt");
    assertEquals("Opening file file1.txt",
        textFileOperationExecutor.executeOperation(textFile::open));
  }

  @Test
  public void testSaveMethodReference() {
    TextFile textFile = new TextFile("file1.txt");
    assertEquals("Saving file file1.txt",
        textFileOperationExecutor.executeOperation(textFile::save));
  }

  @Test
  public void testOpenApply() {
    Function<TextFileOperationOpen, String> executeMethodReference = TextFileOperationOpen::execute;
    TextFile textFile = new TextFile("file1.txt");
    assertEquals("Opening file file1.txt",
        executeMethodReference.apply(
            new TextFileOperationOpen(
                new TextFile("file1.txt"))));
  }

  @Test
  public void testSaveApply() {
    Function<TextFileOperationSave, String> executeMethodReference = TextFileOperationSave::execute;
    TextFile textFile = new TextFile("file1.txt");
    assertEquals("Saving file file1.txt",
        executeMethodReference.apply(
            new TextFileOperationSave(
                new TextFile("file1.txt"))));
  }
}
