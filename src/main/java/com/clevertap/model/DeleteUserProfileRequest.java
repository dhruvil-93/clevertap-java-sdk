package com.clevertap.model;

import lombok.Builder;
import lombok.Getter;

import java.util.Set;

@Builder
@Getter
public class DeleteUserProfileRequest {
  private final Set<String> identity;
  private final Set<String> guid;
}
