package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

import java.util.List;
import java.util.Map;

@Getter
@Setter(AccessLevel.NONE)
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class User {
  private String identity;
  private String email;
  private Map<String, Object> profileData;
  private Map<String, EventSummary> events;
  private List<PlatformInfo> platformInfo;
}
