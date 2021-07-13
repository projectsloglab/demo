package com.example.demo.api;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController // will be consumed/used from outside.. RESTful zaqvki
@RequestMapping("/api/get-demo") // customize the end point for clarity
public class GetDemo {
    /*
    @GetMapping
    @PostMapping
    @DeleteMapping
    @PutMapping
    */
    @GetMapping         // this method becomes "root" method
    public ResponseEntity<String> helloWorld(){
        System.out.println("Hello cruel world!");
        return ResponseEntity.status(HttpStatus.OK).body("Hello there, general Kenobi");
    }
    @GetMapping(value = "/bye")
    public ResponseEntity<?> byeWorld(){
        System.out.println("Goodbye cruel world!");
        return ResponseEntity.status(HttpStatus.OK).body(Math.PI);
    }

}
