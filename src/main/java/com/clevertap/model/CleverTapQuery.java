package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class CleverTapQuery {

  private final String eventName;
  private final int from;
  private final int to;
}
