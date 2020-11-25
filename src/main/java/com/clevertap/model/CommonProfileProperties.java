package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class CommonProfileProperties {
  @JsonProperty("profile_fields")
  private final List<ProfileFieldsCriteria> profileFields;

  @JsonProperty("demographics")
  private final List<DemographicsCriteria> demographics;
}
