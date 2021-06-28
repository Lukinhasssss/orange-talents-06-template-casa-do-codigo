package com.lukinhasssss.casa_do_codigo.config.validation;

import java.util.Optional;

import com.lukinhasssss.casa_do_codigo.dto.author.AuthorForm;
import com.lukinhasssss.casa_do_codigo.entities.Author;
import com.lukinhasssss.casa_do_codigo.repositories.AuthorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

@Component
public class AuthorFormEmailValidator implements Validator {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
	public boolean supports(Class<?> clazz) {
		return AuthorForm.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		if (errors.hasErrors()) {
			return;
		}

		AuthorForm request = (AuthorForm) target;

		Optional<Author> author = authorRepository.findByEmail(request.getEmail());

		if (author.isPresent()) {
			errors.rejectValue("email", null,
					"Já existe um(a) outro(a) autor(a) com o mesmo email "
							+ request.getEmail());
		}
	}

}
