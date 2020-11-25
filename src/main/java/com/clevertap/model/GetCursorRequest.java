package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetCursorRequest {

  private final long batchSize;
  private final boolean requireAppFields;
  private final boolean requireEventsSummary;
  private final boolean requireCustomProfileProperties;
  private final CleverTapQuery query;
}
