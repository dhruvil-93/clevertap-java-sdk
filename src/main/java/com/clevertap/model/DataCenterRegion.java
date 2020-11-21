package com.clevertap.model;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataCenterRegion {
  EU1("https://api.clevertap.com"),
  IN1("https://in1.api.clevertap.com"),
  SK1("https://sk1.api.clevertap.com"),
  SG1("https://sg1.api.clevertap.com"),
  US1("https://us1.api.clevertap.com");

  private final String url;
}
