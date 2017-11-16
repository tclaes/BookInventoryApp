package be.tcla.bookinventory.controller;

import be.tcla.bookinventory.model.Book;
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
    public int deleteBook(@RequestBody Book b){
        return service.deleteBook(b);
    }




}
