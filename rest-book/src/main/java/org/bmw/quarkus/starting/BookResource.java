package org.bmw.quarkus.starting;

import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.bmw.quarkus.starting.entities.Book;
import org.bmw.quarkus.starting.repositories.BookRepository;
import org.jboss.logging.Logger;

import java.util.List;
import java.util.Optional;


@Path("/api/books")
@Produces(MediaType.APPLICATION_JSON)
public class BookResource {

    @Inject
    BookRepository bookRepository;

    @Inject
    Logger log;


    @GET
    public List<Book> getAllBooks() {
        log.info("get All books");
        return bookRepository.getAllBook();
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
    public Optional<Book> getBook(@PathParam("id") int id) {
        return getAllBooks().stream()
                .filter(book -> book.id == id)
                .findFirst();
    }

}
