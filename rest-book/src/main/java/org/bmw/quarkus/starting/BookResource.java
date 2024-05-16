package org.bmw.quarkus.starting;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.bmw.quarkus.starting.entities.Book;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @GET
    public List<Book> getAllBooks() {
        //return dummy list of 3 books
        List<Book> books = new ArrayList<>();
        books.add(new Book(1, "Harry Potter", "J.K. Rowling", 1997, "Fantasy"));
        books.add(new Book(2, "The Da Vinci Code", "Dan Brown", 2003, "Mystery"));
        books.add(new Book(3, "The Catcher in the Rye", "J.D. Salinger", 1951, "Fiction"));
        return books;
    }

    @GET
    @Path("/count")
    @Produces(MediaType.TEXT_PLAIN)
    public int countBooks() {
        return getAllBooks().size();
    }

    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Optional<Book> getBook(@PathParam("id") int id){
        return getAllBooks().stream()
                .filter( book -> book.id == id)
                .findFirst();
    }

}
