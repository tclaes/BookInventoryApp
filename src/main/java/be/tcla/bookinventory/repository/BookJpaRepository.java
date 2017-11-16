package be.tcla.bookinventory.repository;

import be.tcla.bookinventory.model.Book;
import be.tcla.bookinventory.model.Genre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookJpaRepository extends JpaRepository<Book, Integer> {

    List<Book> findByAuthorContaining(String author);
    //Book findByIsbn(String isbn);
    List<Book> findByGenreContaining(Genre genre);
    List<Book> findByTitleContaining(String keyword);
    List<Book> findByEbook(boolean ebook);
    Book findByTitleAndAuthorContaining(String title, String author);
}
