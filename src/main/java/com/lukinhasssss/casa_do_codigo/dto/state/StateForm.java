package com.lukinhasssss.casa_do_codigo.dto.state;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.lukinhasssss.casa_do_codigo.config.validation.UniqueValue;
import com.lukinhasssss.casa_do_codigo.entities.Country;
import com.lukinhasssss.casa_do_codigo.entities.State;
import com.lukinhasssss.casa_do_codigo.repositories.CountryRepository;

public class StateForm {

    @NotEmpty @NotBlank
    @UniqueValue(domainClass = State.class, fieldName = "name", message = "Este estado já está cadastrado")
    private String name;

    @NotEmpty @NotBlank
    private String countryName;

    public String getName() {
        return name;
    }

    public String getCountryName() {
        return countryName;
    }

    public State convertToEntity(CountryRepository repository) {
        Country country = repository.findByName(countryName);
        return new State(name, country);
    }

}
