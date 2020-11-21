package com.clevertap.client;

import com.clevertap.api.DataCenterRegion;
import com.clevertap.api.UsersApi;
import com.clevertap.exception.CleverTapException;
import com.clevertap.model.*;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.proxy.WebResourceFactory;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;

public class CleverTapClient {

  private final UsersApi usersApi;

  CleverTapClient(
      DataCenterRegion region, String accountId, String passcode, Configuration configuration) {
    Client client = new JerseyClientBuilder().withConfig(configuration).build();
    client.register(new CleverTapAuthFilter(accountId, passcode));
    WebTarget target = client.target(region.getUrl());
    usersApi = WebResourceFactory.newResource(UsersApi.class, target);
  }

  public GetCursorResponse createCursor(GetCursorRequest request) throws CleverTapException {
    try {
      return usersApi.createCursor(
          request.getBatchSize(),
          request.isRequireAppFields(),
          request.isRequireEventsSummary(),
          request.isRequireCustomProfileProperties(),
          request.getQuery());
    } catch (WebApplicationException e) {
      throw new CleverTapException(e.getResponse().getStatusInfo().toString());
    }
  }

  public GetUsersFromCursorResponse getUsers(GetUsersFromCursorRequest request)
      throws CleverTapException {
    try {
      return usersApi.getUsers(request.getCursor());
    } catch (WebApplicationException e) {
      throw new CleverTapException(e.getResponse().getStatusInfo().toString());
    }
  }

  public GetUserResponse getUser(GetUserRequest request) throws CleverTapException {
    try {
      if (StringUtils.isNotBlank(request.getEmail())) {
        return usersApi.getUserByEmail(request.getEmail());
      }
      if (StringUtils.isNotBlank(request.getIdentity())) {
        return usersApi.getUserByIdentity(request.getIdentity());
      }
      if (StringUtils.isNotBlank(request.getObjectId())) {
        return usersApi.getUserByObjectId(request.getObjectId());
      }
      throw new IllegalArgumentException(
          "atleast one of email/identity/objectId must not be blank");
    } catch (WebApplicationException e) {
      throw new CleverTapException(e.getResponse().getStatusInfo().toString());
    }
  }
}
