package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class SessionPropertyCriteria {
  private final String name;
  private final Object value;
}
