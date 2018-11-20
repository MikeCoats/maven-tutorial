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
    public final void serverReturnsCorrectResult() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":2.0,\"operator\":\"+\",\"rightOperand\":3.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(5.0f));
    }

    @Test
    public final void serverReturnsAnotherCorrectResult() throws Exception {
        given().
            contentType("application/json").
            body("{\"leftOperand\":3.0,\"operator\":\"+\",\"rightOperand\":5.0}").
        when().
            post("/calculate")
        .then()
            .body("result", is(8.0f));
    }

}
