package com.lukinhasssss.casa_do_codigo.dto.book;

import java.time.LocalDate;

import com.lukinhasssss.casa_do_codigo.entities.Book;

public class BookDto {

    private String title;
    private String resume;
    private String sumary;
    private Double price;
    private Integer pages;
    private String isbn;
    private LocalDate publicationDate;

    public BookDto(Book book) {
        title = book.getTitle();
        resume = book.getResume();
        sumary = book.getSumary();
        price = book.getPrice();
        pages = book.getPages();
        isbn = book.getIsbn();
        publicationDate = book.getPublicationDate();
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

}
