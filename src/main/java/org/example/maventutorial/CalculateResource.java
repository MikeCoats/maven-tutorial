package org.example.maventutorial;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;

/**
 * Respond to all rest calls under the calculate end-point.
 */
@Path("/calculate")
public final class CalculateResource {

    /**
     * A dummy result.
     */
    public static final float DUMMY_RESULT = 7.0f;

    /**
     * Handle GET operations with a successful dummy result.
     * @return A dummy result
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getHandler() {
        return Response
                .status(Status.OK)
                .entity(new ResultMessage(DUMMY_RESULT))
                .build();
    }

    /**
     * Handle a POST operation asking for some maths to be done.
     * @param operation The mathematical calculation to perform
     * @return The results of the calculation
     */
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response postHandler(final OperationMessage operation) {
        float left = operation.getLeftOperand();
        float right = operation.getRightOperand();
        String op = operation.getOperator();

        float result;

        if (op.equals("+")) {
            result = left + right;
        } else if (op.equals("-")) {
            result = left - right;
        } else if (op.equals("*")) {
            result = left * right;
        } else if (op.equals("/")) {
            result = left / right;
        } else {
            return Response
                    .status(Status.BAD_REQUEST)
                    .entity("Invalid operator.")
                    .build();
        }

        return Response
                .status(Status.OK)
                .entity(new ResultMessage(result))
                .build();
    }
}
