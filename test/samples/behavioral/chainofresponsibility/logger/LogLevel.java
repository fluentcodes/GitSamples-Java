package samples.behavioral.chainofresponsibility.logger;

public enum LogLevel {
    INFO, DEBUG, WARNING, ERROR, FUNCTIONAL_MESSAGE, FUNCTIONAL_ERROR;

    public static LogLevel[] all() {
      return values();
    }
  }