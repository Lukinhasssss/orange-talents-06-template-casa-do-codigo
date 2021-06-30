package com.lukinhasssss.casa_do_codigo.repositories;

import com.lukinhasssss.casa_do_codigo.entities.Country;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {

    Country findByName(String name);

}
