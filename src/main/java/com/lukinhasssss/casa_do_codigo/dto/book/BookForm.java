package com.lukinhasssss.casa_do_codigo.dto.book;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.validation.constraints.Future;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.lukinhasssss.casa_do_codigo.config.validation.UniqueValue;
import com.lukinhasssss.casa_do_codigo.entities.Author;
import com.lukinhasssss.casa_do_codigo.entities.Book;
import com.lukinhasssss.casa_do_codigo.entities.Category;
import com.lukinhasssss.casa_do_codigo.repositories.AuthorRepository;
import com.lukinhasssss.casa_do_codigo.repositories.CategoryRepository;

import org.springframework.format.annotation.DateTimeFormat;

public class BookForm {

    @NotBlank @NotEmpty
    @UniqueValue(domainClass = Book.class, fieldName = "title", message = "Este livro já existe")
    private String title;

    @NotBlank @NotEmpty @Size(max = 500)
    private String resume;

    @Column(columnDefinition = "TEXT")
    private String sumary;

    @NotNull @Min(value = 20, message = "Deve custar no mínimo R$ 20,00")
    private Double price;

    @NotNull @Min(value = 100, message = "Deve ter no mínimo 100 páginas")
    private Integer pages;

    @NotEmpty @NotBlank
    @UniqueValue(domainClass = Book.class, fieldName = "isbn", message = "Já existe um livro com este isbn")
    private String isbn;

    @Future
    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;

    @NotBlank @NotEmpty
    private String categoryName;

    @NotBlank @NotEmpty
    private String authorName;

    public String getTitle() {
        return title;
    }

    public String getResume() {
        return resume;
    }

    public String getSumary() {
        return sumary;
    }

    public Double getPrice() {
        return price;
    }

    public Integer getPages() {
        return pages;
    }

    public String getIsbn() {
        return isbn;
    }

    public LocalDate getPublicationDate() {
        return publicationDate;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public String getAuthorName() {
        return authorName;
    }

    public Book convertToEntity(CategoryRepository categoryRepository, AuthorRepository authorRepository) {
        Category category = categoryRepository.findByName(categoryName);
        Author author = authorRepository.findByName(authorName);
        return new Book(title, resume, sumary, price, pages, isbn, publicationDate, category, author);
    }

}
