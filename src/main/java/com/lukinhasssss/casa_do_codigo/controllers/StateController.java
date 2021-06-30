package com.lukinhasssss.casa_do_codigo.controllers;

import javax.transaction.Transactional;
import javax.validation.Valid;

import com.lukinhasssss.casa_do_codigo.dto.state.StateForm;
import com.lukinhasssss.casa_do_codigo.entities.State;
import com.lukinhasssss.casa_do_codigo.repositories.CountryRepository;
import com.lukinhasssss.casa_do_codigo.repositories.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/states")
public class StateController {

    @Autowired
    private StateRepository stateRepository;

    @Autowired
    private CountryRepository countryRepository;

    @PostMapping
    @Transactional
    public ResponseEntity<?> insert(@RequestBody @Valid StateForm form) {
        State state = form.convertToEntity(countryRepository);
        stateRepository.save(state);
        return ResponseEntity.ok().build();
    }

}
