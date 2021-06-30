package com.lukinhasssss.casa_do_codigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.lukinhasssss.casa_do_codigo.dto.country.CountryForm;
import com.lukinhasssss.casa_do_codigo.entities.Country;
import com.lukinhasssss.casa_do_codigo.repositories.CountryRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/countries")
public class CountryController {

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<Void> insert(@RequestBody @Valid CountryForm form) {
        Country country = form.convertToEntity();
        countryRepository.save(country);
        return ResponseEntity.ok().build();
    }

}
