package com.clevertap.api;

import com.clevertap.model.CleverTapQuery;
import com.clevertap.model.GetCursorResponse;
import com.clevertap.model.GetUserResponse;
import com.clevertap.model.GetUsersFromCursorResponse;

import javax.ws.rs.*;

@Consumes("application/json")
@Produces("application/json")
public interface UsersApi {

  @Path("/1/profiles.json")
  @POST
  GetCursorResponse createCursor(
      @QueryParam("batch_size") int batchSize,
      @QueryParam("app") boolean requireAppFields,
      @QueryParam("events") boolean requireEventsSummary,
      @QueryParam("profile") boolean requireCustomProfileProperties,
      CleverTapQuery query);

  @Path("/1/profiles.json")
  @GET
  GetUsersFromCursorResponse getUsers(@QueryParam("cursor") String cursor);

  @Path("/1/profile.json")
  @GET
  GetUserResponse getUserByEmail(@QueryParam("email") String email);

  @Path("/1/profile.json")
  @GET
  GetUserResponse getUserByIdentity(@QueryParam("identity") String identity);

  @Path("/1/profile.json")
  @GET
  GetUserResponse getUserByObjectId(@QueryParam("objectId") String objectId);
}
