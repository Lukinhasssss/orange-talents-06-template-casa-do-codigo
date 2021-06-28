package com.lukinhasssss.casa_do_codigo.repositories;

import java.util.Optional;

import com.lukinhasssss.casa_do_codigo.entities.Category;

import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepository extends JpaRepository<Category, Long> {

    Optional<Category> findByName(String name);

}
