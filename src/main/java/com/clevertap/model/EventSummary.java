package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class EventSummary {
  private int count;

  @JsonProperty("first_seen")
  private int firstSeen;

  @JsonProperty("last_seen")
  private int lastSeen;
}
