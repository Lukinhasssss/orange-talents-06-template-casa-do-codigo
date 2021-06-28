package com.lukinhasssss.casa_do_codigo.dto.author;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.lukinhasssss.casa_do_codigo.entities.Author;

public class AuthorForm {

    @NotBlank @NotEmpty
    private String name;

    @Email @NotBlank @NotEmpty
    private String email;

    @Size(max = 400)
    private String description;

    public AuthorForm(String name, String email, String description) {
        this.name = name;
        this.email = email;
        this.description = description;
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

    public Author convertToEntity() {
        return new Author(name, email, description);
    }

}
