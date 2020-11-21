package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

@Getter
@Setter(AccessLevel.NONE)
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class PlatformInfo {
  private String platform;

  @JsonProperty("os_version")
  private String osVersion;

  @JsonProperty("app_version")
  private String appVersion;

  private String make;
  private String model;

  @JsonProperty("push_token")
  private String pushToken;

  private String objectId;
}
