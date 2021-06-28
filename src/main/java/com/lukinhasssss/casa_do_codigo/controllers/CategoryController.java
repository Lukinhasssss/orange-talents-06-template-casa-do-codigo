package com.lukinhasssss.casa_do_codigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.lukinhasssss.casa_do_codigo.config.validation.CategoryFormNameValidator;
import com.lukinhasssss.casa_do_codigo.dto.category.CategoryDto;
import com.lukinhasssss.casa_do_codigo.dto.category.CategoryForm;
import com.lukinhasssss.casa_do_codigo.entities.Category;
import com.lukinhasssss.casa_do_codigo.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/categories")
public class CategoryController {

    @Autowired
    private CategoryRepository categoryRepository;

    @Autowired
    private CategoryFormNameValidator categoryFormNameValidator;

    @InitBinder
	public void init(WebDataBinder binder) {
		binder.addValidators(categoryFormNameValidator);
	}

    @PostMapping
    @Transactional
    public ResponseEntity<CategoryDto> insert(@RequestBody @Valid CategoryForm form) {
        Category category = form.convertToEntity();
        categoryRepository.save(category);
        return ResponseEntity.ok().body(new CategoryDto(category));
    }

}
