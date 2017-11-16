package be.tcla.bookinventory.repository;

import be.tcla.bookinventory.mapper.EnumMapper;
import be.tcla.bookinventory.model.Book;
import be.tcla.bookinventory.model.Genre;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.sql.Types;
import java.util.List;

@Repository
public class BookRepositoryJDBCImpl implements BookRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public BookRepositoryJDBCImpl(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public int addBook(Book book) {
        String sql ="INSERT INTO spring.book VALUES (null, ?, ?, ?, ?, ?, ?, ?, ?, ?)";

        return
        jdbcTemplate.update(sql, ps -> {
            ps.setString(1,book.getISBN());
            ps.setString(2,book.getAuthor());
            ps.setBoolean(3,book.isEbook());
            if(book.getGenre() == null){
                ps.setNull(4,java.sql.Types.INTEGER);
            }
            else ps.setInt(4,book.getGenre().ordinal());

            if(book.getGenre() == null){
                ps.setNull(5, Types.INTEGER);
            }else ps.setInt(5,book.getLanguage().ordinal());

            ps.setInt(6,book.getPages());
            ps.setString(7,book.getPublisher());
            ps.setString(8,book.getSubject());
            ps.setString(9,book.getTitle());

        });
        //return 1;}
//        catch (Exception ex){
//            return 0;
//        }
    }

    @Override
    public int updateBook(Book book) {
        String sql = "UPDATE book SET author=?, ebook=?, genre= ?, isbn= ?, language= ?, pages= ?,publisher=?, subject= ?, title= ?" +
                "  WHERE id = ? ";

        return
                jdbcTemplate.update(sql, ps -> {
                    ps.setString(4,book.getISBN());
                    ps.setString(1,book.getAuthor());
                    ps.setBoolean(2,book.isEbook());
                    if(book.getGenre() == null){
                        ps.setNull(3,java.sql.Types.INTEGER);
                    }
                    else ps.setInt(3,book.getGenre().ordinal());

                    if(book.getGenre() == null){
                        ps.setNull(5, Types.INTEGER);
                    }else ps.setInt(5,book.getLanguage().ordinal());

                    ps.setInt(6,book.getPages());
                    ps.setString(7,book.getPublisher());
                    ps.setString(8,book.getSubject());
                    ps.setString(9,book.getTitle());
                    ps.setInt(10,book.getId());

                });

    }

    @Override
    public int deleteBook(Book book) {
        String sql = "DELETE FROM book WHERE id=?";

        return
            jdbcTemplate.update(sql,ps->{
                ps.setInt(1,book.getId());
            });
    }

    @Override
    public List<Book> findAll() {
        return jdbcTemplate.query("SELECT * FROM book", (resultSet, i) -> {
                    Book book = new Book();
                    book.setAuthor(resultSet.getString("author"));
                    book.setTitle(resultSet.getString("title"));
                    book.setEbook(resultSet.getBoolean("ebook"));
                    book.setISBN(resultSet.getString("isbn"));
                    book.setPages(resultSet.getInt("pages"));
                    book.setPublisher(resultSet.getString("publisher"));
                    book.setSubject(resultSet.getString("subject"));
                    book.setId(resultSet.getInt("id"));

                    //TODO: ENUMS MAPPEN
                    //System.out.println(resultSet.getInt("genre"));
                    if(resultSet.getString("genre")!= null) {
                        book.setGenre(EnumMapper.mapToGenre(Integer.parseInt(resultSet.getString("genre"))));
                    }
                    if(resultSet.getString("language")!=null){
                        book.setLanguage(EnumMapper.mapToLanguage(Integer.parseInt(resultSet.getString("language"))));
                    }

                    return book;
                });

            }


    @Override
    public List<Book> findByAuthor(String author) {
//        String sql = "Select * from book where author like ?";
//        return jdbcTemplate.query(sql,(rs,i)->{
//           rs.setString(1,author);
//        });
        return null;
    }

    @Override
    public List<be.tcla.bookinventory.model.Book> findByGenre(Genre genre) {
        return null;
    }

    @Override
    public List<be.tcla.bookinventory.model.Book> findByKeyword(String keyword) {
        return null;
    }

    @Override
    public List<be.tcla.bookinventory.model.Book> findByEbooks(boolean ebook) {
        return null;
    }

    @Override
    public be.tcla.bookinventory.model.Book findByISBN(String isbn) {
        return null;
    }

    @Override
    public be.tcla.bookinventory.model.Book findByTitleAndAuthor(String title, String author) {
        return null;
    }
}
