package com.example.demo.api;

import com.example.demo.model.Author;
import com.example.demo.repo.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/author")
public class AuthorController {
    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping(value = "/create")
    public ResponseEntity<?> create(@RequestBody Author author){
        authorRepository.save(author);
        return ResponseEntity.ok("Gucci author create");
    }

    @PutMapping(value = "/update")
    public ResponseEntity<?> update(@RequestBody Author author){
        if (author.getId() == 0){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed af");
        }
//        author.setName("Name updated");
//        author.setLastName("Lastname updated");
        authorRepository.save(author);
        return ResponseEntity.ok("Gucci update");
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<?> findAllById(){
        List<Author> authorList = authorRepository.findByOrderByIdAsc();
        return ResponseEntity.ok().body(authorList);
    }

    @GetMapping(value = "/findByName")
    public ResponseEntity<?> findByName(
            @RequestParam(value = "name")
            String name
    ){
        List<Author> authorList = authorRepository.findByName(name);
        return ResponseEntity.ok().body(authorList);
    }
}
