package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.Map;

@Getter
@Setter(AccessLevel.NONE)
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Event {
  private String objectId;
  private String identity;

  @JsonProperty("ts")
  private long timestamp;

  private Map<String, Object> profileData;

  @JsonProperty("event_props")
  private Map<String, Object> eventProperties;

  @JsonProperty("session_props")
  private Map<String, Object> sessionProperties;

  @JsonProperty("session_source")
  private String sessionSource;
}
