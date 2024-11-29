package org.acme.resource;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
public class DataResourceTest {

    @Test
    public void testFetchDataEndpoint() {
        given()
          .when().get("/data/fetch")
          .then()
             .statusCode(200)
             .body(is("{\"status\": \"success\"}"));
    }
}