package be.tcla.bookinventory.controller;

import be.tcla.bookinventory.model.Book;
import be.tcla.bookinventory.model.Genre;
import be.tcla.bookinventory.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    private final BookService service;

    @Autowired
    public BookController(BookService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity findAll(){
     return ResponseEntity.ok(service.findAll());
    }

    @PostMapping("/add")
    public int addBook(@RequestBody Book b){
         return service.addBook(b);
    }

    @PostMapping("/update")
    public int updateBook(@RequestBody Book b){
        return service.updateBook(b);
    }

    @DeleteMapping("/delete/{delete}")
    public int deleteBook(@PathVariable Book b){
        return service.deleteBook(b);
    }

    @RequestMapping(value="/author/{author}", method = RequestMethod.GET)
    public ResponseEntity findByAuthor(@PathVariable String author){
        return ResponseEntity.ok(service.findByAuthor(author));
    }

    @RequestMapping(value="/genre/{genre}", method = RequestMethod.GET)
    public ResponseEntity findByGenre(@PathVariable Genre genre){
        return ResponseEntity.ok(service.findByGenre(genre));
    }

    @RequestMapping(value="/keyword/{keyword}", method = RequestMethod.GET)
    public ResponseEntity findByKeyword(@PathVariable String keyword){
        return ResponseEntity.ok(service.findByKeyword(keyword));
    }

    @RequestMapping(value="/ebook/{ebook}",method = RequestMethod.GET)
    public ResponseEntity findByEbooks(@PathVariable boolean ebook){
        return ResponseEntity.ok(service.findByEbooks(ebook));
    }

    @RequestMapping(value="/title/{title}/author/{author}")
    public ResponseEntity findByTitleAndAuthor(@PathVariable String title, String author){
        return ResponseEntity.ok(service.findByTitleAndAuthor(title, author));
    }


}
