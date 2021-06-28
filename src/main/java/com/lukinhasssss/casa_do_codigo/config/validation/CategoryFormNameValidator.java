package com.lukinhasssss.casa_do_codigo.config.validation;

import java.util.Optional;

import com.lukinhasssss.casa_do_codigo.dto.category.CategoryForm;
import com.lukinhasssss.casa_do_codigo.entities.Category;
import com.lukinhasssss.casa_do_codigo.repositories.CategoryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class CategoryFormNameValidator implements Validator {

    @Autowired
    private CategoryRepository categoryRepository;

    @Override
	public boolean supports(Class<?> clazz) {
		return CategoryForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		CategoryForm dto = (CategoryForm) target;

		Optional<Category> category = categoryRepository.findByName(dto.getName());

		if (category.isPresent()) {
			errors.rejectValue("name", null, "Categoria " + dto.getName() + " já existe");
		}
	}

}
