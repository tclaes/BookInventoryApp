package be.tcla.bookinventory.service;

import be.tcla.bookinventory.BookInventoryApplication;
import be.tcla.bookinventory.model.Book;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = BookInventoryApplication.class)
public class BookServiceTest {

    @Autowired
    private BookService bc;

    @Test
    public void testFindAll(){
        List<Book> books = bc.findAll();
        assertThat(books).isNotEmpty();
    };
}
