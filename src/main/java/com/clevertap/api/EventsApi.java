package com.clevertap.api;

import com.clevertap.model.CleverTapQuery;
import com.clevertap.model.GetCursorResponse;
import com.clevertap.model.GetUsersFromCursorResponse;

import javax.ws.rs.*;

@Consumes("application/json")
@Produces("application/json")
public interface EventsApi {

  @Path("/1/events.json")
  @POST
  GetCursorResponse createCursor(
      @QueryParam("batch_size") int batchSize,
      @QueryParam("app") boolean requireAppFields,
      @QueryParam("events") boolean requireEventsSummary,
      @QueryParam("profile") boolean requireCustomProfileProperties,
      CleverTapQuery query);

  @Path("/1/events.json")
  @GET
  GetUsersFromCursorResponse getUsers(@QueryParam("cursor") String cursor);
}
