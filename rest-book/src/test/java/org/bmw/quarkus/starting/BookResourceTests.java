package org.bmw.quarkus.starting;

import io.quarkus.test.junit.QuarkusTest;
import jakarta.ws.rs.core.HttpHeaders;
import org.junit.jupiter.api.Test;



import static io.restassured.RestAssured.given;
import static org.hamcrest.CoreMatchers.is;

@QuarkusTest
class BookResourceTests {
    @Test
    void shouldGetAllBooks() {
        given()
                .header(HttpHeaders.ACCEPT, "application/json").
                when()
                .get("/api/books")
                .then()
                .statusCode(200)
                .body("$.size()", is(3));
    }

    @Test
    void shouldCountAllBooks(){
        given()
                .header(HttpHeaders.ACCEPT, "text/plain")
                .when()
                .get("/api/books/count")
                .then()
                .statusCode(200)
                .body(is("3"));
    }

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
                .body("genre", is("Fantasy"));
    }

}
