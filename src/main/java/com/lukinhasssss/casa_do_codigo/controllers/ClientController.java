package com.lukinhasssss.casa_do_codigo.controllers;

import javax.validation.Valid;

import com.lukinhasssss.casa_do_codigo.dto.client.ClientForm;
import com.lukinhasssss.casa_do_codigo.dto.client.ClientResponse;
import com.lukinhasssss.casa_do_codigo.entities.Client;
import com.lukinhasssss.casa_do_codigo.repositories.ClientRepository;
import com.lukinhasssss.casa_do_codigo.repositories.CountryRepository;
import com.lukinhasssss.casa_do_codigo.repositories.StateRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clients")
public class ClientController {

    @Autowired
    private ClientRepository clientRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private StateRepository stateRepository;

    @PostMapping
    public ResponseEntity<ClientResponse> insert(@RequestBody @Valid ClientForm form) {
        Client client = form.convertToEntity(countryRepository, stateRepository);
        clientRepository.save(client);
        return ResponseEntity.ok().body(new ClientResponse(client));
    }

}
