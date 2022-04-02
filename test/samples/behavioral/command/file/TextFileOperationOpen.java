package samples.behavioral.command.file;

public class TextFileOperationOpen implements TextFileOperation {

  private final TextFile textFile;

  public TextFileOperationOpen(TextFile textFile) {
    this.textFile = textFile;
  }

  @Override
  public String execute() {
    return textFile.open();
  }
}
