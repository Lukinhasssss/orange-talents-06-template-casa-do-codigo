package com.lukinhasssss.casa_do_codigo.dto.country;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;

import com.lukinhasssss.casa_do_codigo.config.validation.UniqueValue;
import com.lukinhasssss.casa_do_codigo.entities.Country;

public class CountryForm {

    @NotEmpty @NotBlank
    @UniqueValue(domainClass = Country.class, fieldName = "name", message = "Já existe outro país com este mesmo nome")
    private String name;

    public String getName() {
        return name;
    }

    public Country convertToEntity() {
        return new Country(name);
    }

}
