package be.tcla.bookinventory.repository;

import be.tcla.bookinventory.model.Book;
import be.tcla.bookinventory.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepositoryHibernateImpl implements BookRepository {

    private final BookJpaRepository repository;

    @Autowired
    public BookRepositoryHibernateImpl(BookJpaRepository repository) {
        this.repository = repository;
    }

    @Override
    public int addBook(Book book) {
        Book b = repository.saveAndFlush(book);
        return b != null ? 1:0;
    }

    @Override
    public int updateBook(Book book) {
        Book b = repository.saveAndFlush(book);
        return b!=null?1:0;
    }

    @Override
    public int deleteBook(Book book) {
        repository.delete(book);
        return 1;
    }

    @Override
    public List<Book> findAll() {
        return repository.findAll();
    }


    @Override
    @Query
    public List<Book> findByAuthor(String author) {
        return repository.findByAuthorContaining(author);
    }

    @Override
    @Query
    public List<Book> findByGenre(Genre genre) {

        return repository.findByGenreContaining(genre);
    }

    @Override
    @Query
    public List<Book> findByKeyword(String keyword) {
        return repository.findByTitleOrBydAuthorContaining(keyword);
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
