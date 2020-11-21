package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetUsersFromCursorRequest {
  private final String cursor;
}
