package com.lukinhasssss.casa_do_codigo.dto.category;

import com.lukinhasssss.casa_do_codigo.entities.Category;

public class CategoryDto {

    private Long id;
    private String name;

    public CategoryDto(Category category) {
        id = category.getId();
        name = category.getName();
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
