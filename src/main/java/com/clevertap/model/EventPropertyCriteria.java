package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class EventPropertyCriteria {
  private final String name;
  private final Operator operator;
  private final Object value;
}
