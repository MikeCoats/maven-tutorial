package org.example.maventutorial;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/calculate")
public final class CalculateResource {

    @GET
    public Response getHandler() {
        return Response.status(Status.OK).build();
    }
}