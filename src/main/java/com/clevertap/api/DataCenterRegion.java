package com.clevertap.api;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum DataCenterRegion {
  EU("https://api.clevertap.com"),
  IN("https://in.api.clevertap.com"),
  SK1("https://sk1.api.clevertap.com"),
  SG("https://sg.api.clevertap.com"),
  US("https://us.api.clevertap.com");

  private final String url;
}
