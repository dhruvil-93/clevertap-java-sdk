package com.clevertap.api;

import com.clevertap.model.*;

import javax.ws.rs.*;

@Consumes("application/json")
@Produces("application/json")
public interface UserApi {

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

  @Path("/1/upload")
  @POST
  UploadUsersResponse uploadUser(UploadUsersRequest request);
}
