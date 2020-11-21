package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetEventsFromCursorRequest {
  private final String cursor;
}
