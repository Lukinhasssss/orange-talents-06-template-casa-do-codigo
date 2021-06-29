package com.lukinhasssss.casa_do_codigo.dto.book;

import com.lukinhasssss.casa_do_codigo.entities.Book;

public class BookDetails {

    private String title;
    private String resume;
    private String sumary;
    private Double price;
    private Integer pages;
    private String isbn;
    private String authorName;
    private String authorDescription;

    public BookDetails(Book book) {
        title = book.getTitle();
        resume = book.getResume();
        sumary = book.getSumary();
        price = book.getPrice();
        pages = book.getPages();
        isbn = book.getIsbn();
        authorName = book.getAuthor().getName();
        authorDescription = book.getAuthor().getDescription();
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

    public String getAuthorName() {
        return authorName;
    }

    public String getAuthorDescription() {
        return authorDescription;
    }

}
