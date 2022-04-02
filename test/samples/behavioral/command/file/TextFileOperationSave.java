package samples.behavioral.command.file;

public class TextFileOperationSave implements TextFileOperation {

  private final TextFile textFile;

  public TextFileOperationSave(TextFile textFile) {
    this.textFile = textFile;
  }

  @Override
  public String execute() {
    return textFile.save();
  }
}
