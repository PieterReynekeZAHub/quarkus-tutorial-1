package org.bmw.quarkus.starting;

import io.quarkus.test.junit.QuarkusIntegrationTest;
import jakarta.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusIntegrationTest
public class NativeBookResourceTestIT extends BookResourceTests{

        // Execute the same tests but in native mode.
        @Test
        void shouldGetABook(){
            given()
                    .header(HttpHeaders.ACCEPT, "application/json")
                    .pathParam("id", 1)
                    .when()
                    .get("/api/books/{id}")
                    .then()
                    .statusCode(200)
                    .body("title", is("Harry Potter"))
                    .body("author", is("J.K. Rowling"))
                    .body("yearOfPublication", is(1997))
                    .body("genre", is("Romance"));
        }
}
