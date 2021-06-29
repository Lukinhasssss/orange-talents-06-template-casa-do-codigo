package com.lukinhasssss.casa_do_codigo.repositories;

import com.lukinhasssss.casa_do_codigo.entities.Book;

import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
