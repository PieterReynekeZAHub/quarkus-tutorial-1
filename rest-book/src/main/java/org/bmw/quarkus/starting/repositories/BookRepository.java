package org.bmw.quarkus.starting.repositories;

import jakarta.enterprise.context.ApplicationScoped;
import org.bmw.quarkus.starting.entities.Book;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.util.List;
import java.util.Optional;

@ApplicationScoped
public class BookRepository {

    @ConfigProperty(name = "book.genre", defaultValue = "Fantasy")
    String genre;

    public List<Book> getAllBook() {
        return List.of(
                new Book(1, "Harry Potter", "J.K. Rowling", 1997, genre),
                new Book(2, "The Da Vinci Code", "Dan Brown", 2003, genre),
                new Book(3, "The Catcher in the Rye", "J.D. Salinger", 1951, genre)
        );
    }

    public Optional<Book> getBookById(int id) {
        return getAllBook().stream()
                .filter(book -> book.id == id)
                .findFirst();
    }


}
