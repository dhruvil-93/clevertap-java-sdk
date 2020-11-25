package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class DisassociateRecord {
  private final Type type;
  private final String value;

  public enum Type {
    phone
  }
}
