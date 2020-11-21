package com.clevertap.client;

import com.clevertap.api.DataCenterRegion;
import com.clevertap.api.UsersApi;
import com.clevertap.model.*;
import com.clevertap.service.UsersService;
import org.apache.http.client.HttpClient;

public class CleverTapClient implements UsersApi {

  private final UsersApi usersApi;

  CleverTapClient(DataCenterRegion region, String accountId, String passcode, HttpClient client) {
    usersApi = new UsersService(region, accountId, passcode, client);
  }

  public GetCursorResponse createCursor(GetCursorRequest request) {
    return usersApi.createCursor(request);
  }

  public GetUsersFromCursorResponse getUsers(GetUsersFromCursorRequest request) {
    return usersApi.getUsers(request);
  }

  public GetUserResponse getUser(GetUserRequest request) {
    return usersApi.getUser(request);
  }
}
