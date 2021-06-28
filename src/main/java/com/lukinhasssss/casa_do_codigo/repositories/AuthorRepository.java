package com.lukinhasssss.casa_do_codigo.repositories;

import com.lukinhasssss.casa_do_codigo.entities.Author;

import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
