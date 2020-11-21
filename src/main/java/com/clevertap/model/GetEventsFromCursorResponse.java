package com.clevertap.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;

@Getter
@Setter(AccessLevel.NONE)
@Builder
@AllArgsConstructor
@NoArgsConstructor(access = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class GetEventsFromCursorResponse {
  private ApiResponseStatus status;

  @JsonProperty("previous_cursor")
  private String previousCursor;

  @JsonProperty("next_cursor")
  private String nextCursor;

  @JsonProperty("records")
  private List<Event> users;
}
