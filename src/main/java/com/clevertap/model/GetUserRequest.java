package com.clevertap.model;

import lombok.Getter;
import org.apache.commons.lang3.StringUtils;

@Getter
public class GetUserRequest {

  private final String email;
  private final String identity;
  private final String objectId;

  private GetUserRequest(String email, String identity, String objectId) {
    this.email = email;
    this.identity = identity;
    this.objectId = objectId;
  }

  public static class GetUserRequestBuilder {

    private String email;
    private String identity;
    private String objectId;

    public static GetUserRequestBuilder withEmail(String email) {
      if (StringUtils.isBlank(email)) {
        throw new IllegalArgumentException("email must not be blank");
      }
      GetUserRequestBuilder builder = new GetUserRequestBuilder();
      builder.email = email;
      return builder;
    }

    public static GetUserRequestBuilder withIdentity(String identity) {
      if (StringUtils.isBlank(identity)) {
        throw new IllegalArgumentException("identity must not be blank");
      }
      GetUserRequestBuilder builder = new GetUserRequestBuilder();
      builder.identity = identity;
      return builder;
    }

    public static GetUserRequestBuilder withObjectId(String objectId) {
      if (StringUtils.isBlank(objectId)) {
        throw new IllegalArgumentException("objectId must not be blank");
      }
      GetUserRequestBuilder builder = new GetUserRequestBuilder();
      builder.objectId = objectId;
      return builder;
    }

    public GetUserRequest build() {
      return new GetUserRequest(email, identity, objectId);
    }
  }
}
