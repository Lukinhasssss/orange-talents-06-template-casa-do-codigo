package com.lukinhasssss.casa_do_codigo.controllers;

import com.lukinhasssss.casa_do_codigo.entities.Author;
import com.lukinhasssss.casa_do_codigo.repositories.AuthorRepository;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/authors")
public class AuthorController {

    AuthorRepository authorRepository;

    private AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    public ResponseEntity<Author> insert(@RequestBody Author author) {
        Author insertAuthor = authorRepository.save(author);
        return ResponseEntity.ok().body(insertAuthor);
    }

}
