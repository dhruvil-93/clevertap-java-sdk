package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CleverTapQuery {

  private final String eventName;

  @JsonProperty("event_properties")
  private final List<EventPropertyCriteria> eventProperties;

  @JsonProperty("session_properties")
  private final List<SessionPropertyCriteria> sessionProperties;

  @JsonProperty("common_profile_properties")
  private final CommonProfileProperties commonProfileProperties;

  private final long from;
  private final long to;
}
