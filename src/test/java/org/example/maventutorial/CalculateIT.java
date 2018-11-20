package org.example.maventutorial;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.lessThan;

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

}
