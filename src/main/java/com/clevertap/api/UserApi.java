package com.clevertap.api;

import com.clevertap.model.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface UserApi {

  @Path("/1/profiles.json")
  @POST
  GetCursorResponse createCursor(
      @QueryParam("batch_size") long batchSize,
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

  @Path("/1/counts/profiles.json")
  @POST
  GetProfileCountResponse getProfileCount(
      @QueryParam("req_id") long requestId, CleverTapQuery query);

  @Path("/1/delete/profiles.json")
  @POST
  DeleteUserProfileResponse deleteUserProfile(DeleteUserProfileRequest request);

  @Path("/1/demerge/profiles.json")
  @POST
  DemergeUserProfileResponse demergeUserProfile(DemergeUserProfileRequest request);

  @Path("/1/subscribe")
  @POST
  SubscribeResponse subscribe(SubscribeRequest request);

  @Path("/1/disassociate")
  @POST
  DisassociateResponse disassociate(DisassociateRequest request);
}
