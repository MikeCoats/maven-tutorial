package org.example.maventutorial;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

@Path("/calculate")
public final class CalculateResource {

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHandler() {
        return Response
                .status(Status.OK)
                .entity(new ResultMessage(7.0f))
                .build();
    }

    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postHandler(final OperationMessage operation) {
        return Response
                .status(Status.OK)
                .entity(new ResultMessage(operation.getLeftOperand() + operation.getRightOperand()))
                .build();
    }
}
