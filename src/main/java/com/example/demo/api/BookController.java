package com.example.demo.api;

import com.example.demo.model.Book;
import com.example.demo.repo.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/book")
public class BookController {
    @Autowired
    private BookRepository bookRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create (@RequestBody Book book){
        bookRepository.save(book);
        return ResponseEntity.ok("Gucci book create");
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody Book book){
        if (book.getId() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed book update");
        }
//        book.setName("Updated book name");
//        book.setGenre("Updated book genre");
//        book.setPrice(6969);
        bookRepository.save(book);
        return ResponseEntity.ok("Gucci book update");
    }

    @GetMapping(value="/findAll")
    public ResponseEntity<?> findAllById(){
        List<Book> bookList = bookRepository.findByOrderByIdAsc();
        return ResponseEntity.ok().body(bookList);
    }

    @GetMapping(value = "/findByNameLike")
    public ResponseEntity<?> findByNameLike(
            @RequestParam(value = "name") String name
    ){
        List<Book> bookList = bookRepository.findByNameLike("%"+name+"%");
        return ResponseEntity.ok().body(bookList);
    }

    @GetMapping(value ="/getPage")
    public ResponseEntity<?> limitOffset (
            @RequestParam(value = "offset") int offset,
            @RequestParam(value = "limit") int limit
    ){
        Pageable page = PageRequest.of(1,4);
        List<Book> bookList = bookRepository.findAll(page).getContent();
        return ResponseEntity.ok().body(bookList);
    }

}
