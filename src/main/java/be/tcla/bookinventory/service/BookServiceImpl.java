package be.tcla.bookinventory.service;


import be.tcla.bookinventory.model.Book;
import be.tcla.bookinventory.model.Genre;
import be.tcla.bookinventory.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.MessageSource;

import org.springframework.stereotype.Service;


import java.util.List;
import java.util.Locale;

@Service
public class BookServiceImpl implements BookService {

    private final MessageSource msg;

    private final BookRepository repository;

//bookRepositoryJDBCImpl

    @Autowired
    public BookServiceImpl(@Qualifier("bookRepositoryHibernateImpl") BookRepository repository, MessageSource msg) {
        //public BookServiceImpl(@Qualifier("bookRepositoryHibernateImpl") BookRepository repository) {
        this.repository = repository;
        this.msg = msg;

    }

    @Override
    public int addBook(Book book) {
        return repository.addBook(book);
    }

    @Override
    public int updateBook(Book book) {
        return 0;
    }

    @Override
    public int deleteBook(Book book) {
        return repository.deleteBook(book);
    }

    @Override
    public List<Book> findAll() {
        // Extra logica toevoegen...
        System.out.println(
        msg.getMessage("title", null, Locale.ENGLISH));
        return repository.findAll();
    }

    @Override
    public List<Book> findByAuthor(String author) {
        return null;
    }

    @Override
    public List<Book> findByGenre(Genre genre) {
        return null;
    }

    @Override
    public List<Book> findByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<Book> findByEbooks(boolean ebook) {
        return null;
    }

    @Override
    public Book findByISBN(String isbn) {
        return null;
    }

    @Override
    public Book findByTitleAndAuthor(String title, String author) {
        return null;
    }
}