package com.lukinhasssss.casa_do_codigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.lukinhasssss.casa_do_codigo.dto.book.BookDto;
import com.lukinhasssss.casa_do_codigo.dto.book.BookForm;
import com.lukinhasssss.casa_do_codigo.entities.Book;
import com.lukinhasssss.casa_do_codigo.repositories.AuthorRepository;
import com.lukinhasssss.casa_do_codigo.repositories.BookRepository;
import com.lukinhasssss.casa_do_codigo.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private AuthorRepository authorRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<BookDto> insert(@RequestBody @Valid BookForm form) {
        Book book = form.convertToEntity(categoryRepository, authorRepository);
        bookRepository.save(book);
        return ResponseEntity.ok().body(new BookDto(book));
    }

}
