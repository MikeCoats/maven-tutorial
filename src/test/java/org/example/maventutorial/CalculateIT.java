package org.example.maventutorial;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.Matchers.hasKey;
import static org.hamcrest.Matchers.is;

import org.junit.BeforeClass;
import org.junit.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;

public class CalculateIT {
    @BeforeClass
    public static void setup() {
        RestAssured.baseURI = "http://localhost";
        RestAssured.port = 8080;
        RestAssured.basePath = "/maventutorial";
    }

    @Test
    public final void serverResponds() throws Exception {
        given().
        when().
            get("/calculate")
        .then()
            .time(lessThan(10000L));
    }

    @Test
    public final void serverReturns200Code() throws Exception {
        given().
        when().
            get("/calculate")
        .then()
            .statusCode(200);
    }

    @Test
    public final void serverReturnsJson() throws Exception {
        given().
        when().
            get("/calculate")
        .then()
            .assertThat().contentType(ContentType.JSON);
    }

    @Test
    public final void serverReturnsResultObject() throws Exception {
        given().
        when().
            get("/calculate")
        .then()
            .body("", hasKey("result"));
    }

    @Test
    public final void serverReturnsCorrectAddition() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":2.0,\"operator\":\"+\",\"rightOperand\":3.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(5.0f));
    }

    @Test
    public final void serverReturnsAnotherCorrectAddition() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":3.0,\"operator\":\"+\",\"rightOperand\":5.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(8.0f));
    }

    @Test
    public final void serverReturnsCorrectSubtraction() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":4.0,\"operator\":\"-\",\"rightOperand\":1.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(3.0f));
    }

    @Test
    public final void serverReturnsAnotherCorrectSubtraction() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":2.0,\"operator\":\"-\",\"rightOperand\":7.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(-5.0f));
    }

    @Test
    public final void serverReturnsCorrectMultiplication() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":4.2,\"operator\":\"*\",\"rightOperand\":1.5}").
        when().
            post("/calculate")
        .then()
            .body("result", is(6.3f));
    }

    @Test
    public final void serverReturnsAnotherCorrectMultiplication() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":2.3,\"operator\":\"*\",\"rightOperand\":2.3}").
        when().
            post("/calculate")
        .then()
            .body("result", is(5.29f));
    }

    @Test
    public final void serverReturnsCorrectDivision() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":6.4,\"operator\":\"/\",\"rightOperand\":2.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(3.2f));
    }

    @Test
    public final void serverReturnsAnotherCorrectDivision() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":3.0,\"operator\":\"/\",\"rightOperand\":3.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(1.0f));
    }
}
