package com.clevertap.exception;

public class CleverTapException extends Exception {
  public CleverTapException() {
    super();
  }

  public CleverTapException(String message) {
    super(message);
  }

  public CleverTapException(String message, Throwable cause) {
    super(message, cause);
  }

  public CleverTapException(Throwable cause) {
    super(cause);
  }

  protected CleverTapException(
      String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
