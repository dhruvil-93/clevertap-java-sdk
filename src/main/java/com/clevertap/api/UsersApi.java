package com.clevertap.api;

import com.clevertap.exception.CleverTapException;
import com.clevertap.model.*;

public interface UsersApi {
  GetCursorResponse createCursor(GetCursorRequest request) throws CleverTapException;

  GetUsersFromCursorResponse getUsers(GetUsersFromCursorRequest request);

  GetUserResponse getUser(GetUserRequest request);
}
