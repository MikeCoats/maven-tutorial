package org.example.maventutorial;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.lessThan;

import javax.ws.rs.core.Response.Status;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

/**
 * Integration tests for /calculate.
 */
public class CalculateIT {

    /**
     * How long to wait before failing.
     */
    public static final long TEN_SECONDS = 10000L;
    /**
     * What port is the application served on.
     */
    public static final int AS_PORT = 8080;

    /**
     * Standard set-up for Rest-Assured.
     */
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = AS_PORT;
        RestAssured.basePath = "/maventutorial";
    }

    /**
     * Test server responds in 10s.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverResponds()
            throws Exception {
        given().
        when().
            get("/calculate")
        .then()
            .time(lessThan(TEN_SECONDS));
    }

    /**
     * Test server responds with a 200.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturns200Code()
            throws Exception {
        given().
        when().
            get("/calculate")
        .then()
            .statusCode(Status.OK.getStatusCode());
    }

    /**
     * Test server responds with some JSON.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsJson()
            throws Exception {
        given().
        when().
            get("/calculate")
        .then()
            .assertThat().contentType(ContentType.JSON);
    }

    /**
     * Test server returns a correctly shaped JSON object.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsResultObject()
            throws Exception {
        given().
        when().
            get("/calculate")
        .then()
            .body("", hasKey("result"));
    }

    /**
     * Test server performs addition correctly.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsCorrectAddition()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":2.0,"
                + "\"operator\":\"+\","
                + "\"rightOperand\":3.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(5.0f));
    }

    /**
     * Test server performs addition correctly again.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsAnotherCorrectAddition()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":3.0,"
                + "\"operator\":\"+\","
                + "\"rightOperand\":5.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(8.0f));
    }

    /**
     * Test server performs subtraction correctly.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsCorrectSubtraction()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":4.0,"
                + "\"operator\":\"-\","
                + "\"rightOperand\":1.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(3.0f));
    }

    /**
     * Test server performs subtraction correctly again.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsAnotherCorrectSubtraction()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":2.0,"
                + "\"operator\":\"-\","
                + "\"rightOperand\":7.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(-5.0f));
    }

    /**
     * Test server performs multiplication correctly.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsCorrectMultiplication()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":4.4,"
                + "\"operator\":\"*\","
                + "\"rightOperand\":2.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(8.8f));
    }

    /**
     * Test server performs multiplication correctly again.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsAnotherCorrectMultiplication()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":2.3,"
                + "\"operator\":\"*\","
                + "\"rightOperand\":2.3}").
        when().
            post("/calculate")
        .then()
            .body("result", is(5.29f));
    }

    /**
     * Test server performs division correctly.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsCorrectDivision()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":6.4,"
                + "\"operator\":\"/\","
                + "\"rightOperand\":2.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(3.2f));
    }

    /**
     * Test server performs division correctly again.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsAnotherCorrectDivision()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":3.0,"
                + "\"operator\":\"/\","
                + "\"rightOperand\":3.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(1.0f));
    }

    /**
     * Test server returns error on invalid function.
     * @throws Exception if anything goes wrong
     */
    @Test
    public final void serverReturnsErrorOnUnsupportedOperator()
            throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":3.0,"
                + "\"operator\":\"^\","
                + "\"rightOperand\":2.0}").
        when().
            post("/calculate")
        .then()
            .statusCode(Status.BAD_REQUEST.getStatusCode());
    }
}
