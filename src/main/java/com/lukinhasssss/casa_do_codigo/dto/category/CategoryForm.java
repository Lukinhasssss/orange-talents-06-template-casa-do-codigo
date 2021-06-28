package com.lukinhasssss.casa_do_codigo.dto.category;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.lukinhasssss.casa_do_codigo.entities.Category;

public class CategoryForm {

    @NotEmpty @NotBlank
    private String name;

    public String getName() {
        return name;
    }

    public Category convertToEntity() {
        return new Category(name);
    }

}
