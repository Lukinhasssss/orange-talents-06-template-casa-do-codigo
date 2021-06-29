package com.lukinhasssss.casa_do_codigo.controllers;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.lukinhasssss.casa_do_codigo.dto.book.BookDetails;
import com.lukinhasssss.casa_do_codigo.dto.book.BookDto;
import com.lukinhasssss.casa_do_codigo.dto.book.BookForm;
import com.lukinhasssss.casa_do_codigo.dto.book.BookListing;
import com.lukinhasssss.casa_do_codigo.entities.Book;
import com.lukinhasssss.casa_do_codigo.repositories.AuthorRepository;
import com.lukinhasssss.casa_do_codigo.repositories.BookRepository;
import com.lukinhasssss.casa_do_codigo.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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

    @GetMapping
    public List<BookListing> findAll() {
        List<Book> books = bookRepository.findAll();
        return BookListing.convertToDto(books);
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetails> findById(@PathVariable Long id) {
        Optional<Book> book = bookRepository.findById(id);

        if (book.isPresent())
            return ResponseEntity.ok(new BookDetails(book.get()));

        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @Transactional
    public ResponseEntity<BookDto> insert(@RequestBody @Valid BookForm form) {
        Book book = form.convertToEntity(categoryRepository, authorRepository);
        bookRepository.save(book);
        return ResponseEntity.ok().body(new BookDto(book));
    }

}
