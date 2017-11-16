package be.tcla.bookinventory.repository;

import be.tcla.bookinventory.model.Book;
import be.tcla.bookinventory.model.Genre;

import java.util.List;

public interface BookRepository {

    int addBook(Book book);
    int updateBook(Book book);
    int deleteBook(Book book);

    List<Book> findAll();
    List<Book> findByAuthor(String author);
    List<Book> findByGenre(Genre genre);
    List<Book> findByKeyword(String keyword);
    List<Book> findByEbooks(boolean ebook);

    Book findByISBN(String isbn);
    Book findByTitleAndAuthor(String title, String author);

}
