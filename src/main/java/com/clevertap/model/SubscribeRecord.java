package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SubscribeRecord {
  private final Type type;
  private final String value;
  private final Status status;

  public enum Type {
    email,
    phone
  }

  public enum Status {
    Unsubscribe,
    Resubscribe
  }
}
