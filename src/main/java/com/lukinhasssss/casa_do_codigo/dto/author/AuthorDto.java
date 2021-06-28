package com.lukinhasssss.casa_do_codigo.dto.author;

import java.time.Instant;

import com.lukinhasssss.casa_do_codigo.entities.Author;

public class AuthorDto {

    private Long id;
    private String name;
    private String email;
    private String description;
    private Instant registeredAt = Instant.now();

    public AuthorDto(Author author) {
        id = author.getId();
        name = author.getName();
        email = author.getEmail();
        description = author.getDescription();
        registeredAt = author.getRegisteredAt();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getDescription() {
        return description;
    }

    public Instant getRegisteredAt() {
        return registeredAt;
    }

}
