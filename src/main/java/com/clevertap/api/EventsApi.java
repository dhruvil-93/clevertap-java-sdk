package com.clevertap.api;

import com.clevertap.model.CleverTapQuery;
import com.clevertap.model.GetCursorResponse;
import com.clevertap.model.GetUsersFromCursorResponse;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public interface EventsApi {

  @Path("/1/events.json")
  @POST
  GetCursorResponse createCursor(
      @QueryParam("batch_size") long batchSize,
      @QueryParam("app") boolean requireAppFields,
      @QueryParam("events") boolean requireEventsSummary,
      @QueryParam("profile") boolean requireCustomProfileProperties,
      CleverTapQuery query);

  @Path("/1/events.json")
  @GET
  GetUsersFromCursorResponse getUsers(@QueryParam("cursor") String cursor);
}
