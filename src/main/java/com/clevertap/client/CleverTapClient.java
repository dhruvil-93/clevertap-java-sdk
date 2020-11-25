package com.clevertap.client;

import com.clevertap.api.UserApi;
import com.clevertap.exception.CleverTapException;
import com.clevertap.model.*;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.lang3.StringUtils;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.glassfish.jersey.client.proxy.WebResourceFactory;
import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJaxbJsonProvider;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.Configuration;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.TimeZone;

public class CleverTapClient {

  private final UserApi usersApi;

  CleverTapClient(
      DataCenterRegion region, String accountId, String passcode, Configuration configuration) {
    ObjectMapper mapper = new ObjectMapper();
    DateFormat df = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ssZ");
    df.setTimeZone(TimeZone.getTimeZone("UTC"));
    mapper.setDateFormat(df);
    mapper.setSerializationInclusion(JsonInclude.Include.NON_EMPTY);
    mapper.enable(DeserializationFeature.USE_LONG_FOR_INTS);
    mapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

    JacksonJaxbJsonProvider provider = new JacksonJaxbJsonProvider();
    provider.setMapper(mapper);

    Client client = new JerseyClientBuilder().withConfig(configuration).build();
    client.register(new CleverTapAuthFilter(accountId, passcode));
    WebTarget target = client.target(region.getUrl());
    usersApi = WebResourceFactory.newResource(UserApi.class, target);
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

  public GetProfileCountResponse getProfileCount(GetProfileCountRequest request)
      throws CleverTapException {
    try {
      return usersApi.getProfileCount(request.getRequestId(), request.getQuery());
    } catch (WebApplicationException e) {
      throw new CleverTapException(e.getResponse().getStatusInfo().toString());
    }
  }

  public DeleteUserProfileResponse deleteProfiles(DeleteUserProfileRequest request)
      throws CleverTapException {
    try {
      return usersApi.deleteUserProfile(request);
    } catch (WebApplicationException e) {
      throw new CleverTapException(e.getResponse().getStatusInfo().toString());
    }
  }

  public DemergeUserProfileResponse demergeProfiles(DemergeUserProfileRequest request)
      throws CleverTapException {
    try {
      return usersApi.demergeUserProfile(request);
    } catch (WebApplicationException e) {
      throw new CleverTapException(e.getResponse().getStatusInfo().toString());
    }
  }

  public SubscribeResponse subscribe(SubscribeRequest request) throws CleverTapException {
    try {
      return usersApi.subscribe(request);
    } catch (WebApplicationException e) {
      throw new CleverTapException(e.getResponse().getStatusInfo().toString());
    }
  }

  public DisassociateResponse disassociate(DisassociateRequest request) throws CleverTapException {
    try {
      return usersApi.disassociate(request);
    } catch (WebApplicationException e) {
      throw new CleverTapException(e.getResponse().getStatusInfo().toString());
    }
  }
}
