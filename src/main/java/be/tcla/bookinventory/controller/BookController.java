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

    @PostMapping
    public int addBook(@RequestBody Book b){
         return service.addBook(b);
    }

    @PostMapping
    public int updateBook(@RequestBody Book b){
        return service.updateBook(b);
    }

    @DeleteMapping
    public int deleteBook(@RequestBody Book b){
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

}
