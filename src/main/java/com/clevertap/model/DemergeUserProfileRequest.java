package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class DemergeUserProfileRequest {
  private final Set<String> identities;
}
