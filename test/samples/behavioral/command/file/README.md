## [GitSamples](/../../tree/master) - [Command Pattern](/../../tree/java-design-pattern/test/samples/behavioural/command): File Example

In this example we encapsulate elementary methods in [TextFile](TextFile.java):


    public String open() {
        return "Opening file " + name;
    }
    
    public String read() {  
        return "Reading file " + name;
    }
    
    public String write() {  
        return "Writing to file " + name;
    }
    
    public String save() {  
        return "Saving file " + name;
    }
    
    public String copy() {  
        return "Copying file " + name;
    }
    
    public String paste() {  
        return "Pasting file " + name;
    }
### Operations
We encapsulate these methods with an execute method in implementations of the [TextFileOperation](TextFileOperation.java):


* [TextFileOperationSave](TextFileOperationSave.java)
* [TextFileOperationOpe](TextFileOperationOpen.java)

### Executor
The executor show how one can execute a list of executions, since all operations become interchangeable.

### Tests

Three test classes you find here:

* [TextFileTest](TextFileTest.java)
* [TextFileOperationTest](TextFileOperationTest.java)
* [TextFileOperationExecutorTest](TextFileOperationExecutorTest.java)

### Links
* https://www.baeldung.com/java-command-pattern
