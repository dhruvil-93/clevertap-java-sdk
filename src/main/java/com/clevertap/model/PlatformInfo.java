package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@Getter
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
