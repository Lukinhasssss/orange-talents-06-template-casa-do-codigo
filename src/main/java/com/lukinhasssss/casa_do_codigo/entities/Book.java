package com.lukinhasssss.casa_do_codigo.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "tb_book")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String title;

    private String resume;

    @Column(columnDefinition = "TEXT")
    private String sumary;
    private Double price;
    private Integer pages;

    @Column(unique = true)
    private String isbn;

    @DateTimeFormat(pattern = "dd/MM/yyyy")
    private LocalDate publicationDate;

    @ManyToOne @NotNull
    private Category category;

    @OneToOne @NotNull
    private Author author;

    public Book(String title, String resume, String sumary, Double price, Integer pages, String isbn, LocalDate publicationDate, Category category, Author author) {
        this.title = title;
        this.resume = resume;
        this.sumary = sumary;
        this.price = price;
        this.pages = pages;
        this.isbn = isbn;
        this.publicationDate = publicationDate;
        this.category = category;
        this.author = author;
    }

    public Long getId() {
        return id;
    }

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

    public Category getCategory() {
        return category;
    }

    public Author getAuthor() {
        return author;
    }

}
