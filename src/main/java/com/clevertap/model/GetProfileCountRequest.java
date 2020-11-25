package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class GetProfileCountRequest {
  @JsonProperty("req_id")
  private final long requestId;

  private final CleverTapQuery query;
}
