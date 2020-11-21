package com.clevertap.service;

import com.clevertap.api.DataCenterRegion;
import com.clevertap.api.UsersApi;
import com.clevertap.exception.CleverTapException;
import com.clevertap.model.*;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;

import java.io.IOException;

public class UsersService extends CleverTapAbstractService implements UsersApi {

  public UsersService(
      DataCenterRegion region, String accountId, String passcode, HttpClient client) {
    super(region, accountId, passcode, client);
  }

  public GetCursorResponse createCursor(GetCursorRequest request) throws CleverTapException {
    HttpPost post = createBaseHttpPostRequest();

    try (CloseableHttpResponse response = (CloseableHttpResponse) getClient().execute(post)) {
      validateResponseStatusCode(response.getStatusLine());
      return null;
    } catch (IOException e) {
      throw new CleverTapException("unable to execute request", e);
    }
  }

  public GetUsersFromCursorResponse getUsers(GetUsersFromCursorRequest request) {
    return null;
  }

  public GetUserResponse getUser(GetUserRequest request) {
    return null;
  }
}
