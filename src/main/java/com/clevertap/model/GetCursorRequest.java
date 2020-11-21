package com.clevertap.model;

public class GetCursorRequest {
  private int batchSize;
  private boolean requireAppFields;
  private boolean requireEventSummary;
  private boolean requireCustomProfileProperties;
  private String eventName;
  private int from;
  private int to;
}
