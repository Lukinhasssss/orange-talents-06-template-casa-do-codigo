package com.lukinhasssss.casa_do_codigo.dto.book;

import java.util.List;
import java.util.stream.Collectors;

import com.lukinhasssss.casa_do_codigo.entities.Book;

public class BookListing {

    private Long id;
    private String title;

    public BookListing(Book book) {
        id = book.getId();
        title = book.getTitle();
    }

    public Long getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public static List<BookListing> convertToDto(List<Book> books) {
        return books.stream().map(book -> new BookListing(book)).collect(Collectors.toList());
    }

}
