package com.clevertap.model;

import java.util.List;
import java.util.Map;

public class User {
  private String email;
  private Map<String, Object> profileData;
  private Map<String, EventSummary> events;
  private List<PlatformInfo> platformInfo;
}
