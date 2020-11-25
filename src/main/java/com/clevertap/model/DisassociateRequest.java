package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@Builder
@Getter
public class DisassociateRequest {
  @JsonProperty("d")
  private final List<DisassociateRecord> disassociateRecords;
}
