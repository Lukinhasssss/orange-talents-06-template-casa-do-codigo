package com.lukinhasssss.casa_do_codigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.lukinhasssss.casa_do_codigo.dto.author.AuthorDto;
import com.lukinhasssss.casa_do_codigo.dto.author.AuthorForm;
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

    private AuthorRepository authorRepository;

    public AuthorController(AuthorRepository authorRepository) {
        this.authorRepository = authorRepository;
    }

    @PostMapping
    @Transactional
    public ResponseEntity<AuthorDto> insert(@RequestBody @Valid AuthorForm form) {
        Author author = form.convertToEntity();
        authorRepository.save(author);
        return ResponseEntity.ok().body(new AuthorDto(author));
    }

}
