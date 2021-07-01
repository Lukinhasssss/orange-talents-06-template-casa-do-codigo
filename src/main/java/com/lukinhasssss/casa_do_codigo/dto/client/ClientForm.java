package com.lukinhasssss.casa_do_codigo.dto.client;

import java.util.Optional;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.lukinhasssss.casa_do_codigo.config.validation.Document;
import com.lukinhasssss.casa_do_codigo.config.validation.UniqueValue;
import com.lukinhasssss.casa_do_codigo.entities.Client;
import com.lukinhasssss.casa_do_codigo.entities.Country;
import com.lukinhasssss.casa_do_codigo.entities.State;
import com.lukinhasssss.casa_do_codigo.repositories.CountryRepository;
import com.lukinhasssss.casa_do_codigo.repositories.StateRepository;

public class ClientForm {

    @Email @NotBlank @NotEmpty
    @UniqueValue(domainClass = Client.class, fieldName = "email", message = "Já existe um cliente com este email")
    private String email;

    @NotBlank @NotEmpty
    private String name;

    @NotBlank @NotEmpty
    private String lastName;

    @Document(message = "CPF/CNPJ inválido")
    @UniqueValue(domainClass = Client.class, fieldName = "document", message = "CPF/CNPJ já cadastrado")
    private String document;

    @NotBlank @NotEmpty
    private String address;

    @NotBlank @NotEmpty
    private String complement;

    @NotBlank @NotEmpty
    private String city;

    @NotNull
    private Long countryId;

    private Long stateId;

    @NotBlank @NotEmpty
    private String phone;

    @NotBlank @NotEmpty
    private String zipCode;

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDocument() {
        return document;
    }

    public String getAddress() {
        return address;
    }

    public String getComplement() {
        return complement;
    }

    public String getCity() {
        return city;
    }

    public Long getCountryId() {
        return countryId;
    }

    public Long getStateId() {
        return stateId;
    }

    public String getPhone() {
        return phone;
    }

    public String getZipCode() {
        return zipCode;
    }

    public Client convertToEntity(CountryRepository countryRepository, StateRepository stateRepository) {
        Country country = countryRepository.findById(countryId).get();

        Optional<State> state = stateId == null ? stateRepository.findById(0L) : stateRepository.findById(stateId);

        if (state.isPresent()) {
            Client client = new Client(email, name, lastName, document, address, complement, city, country, phone, zipCode);
            client.setState(state.get());
            return client;
        }

        return new Client(email, name, lastName, document, address, complement, city, country, phone, zipCode);
    }

}
