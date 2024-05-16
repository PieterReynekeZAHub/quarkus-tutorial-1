package org.bmw.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTests {
    @Test
    void testHelloEndpoint() {
        given()
          .when().get("/api/books")
          .then()
             .statusCode(200)
             .body(is("Hello Books"));
    }

}
