package com.lukinhasssss.casa_do_codigo.repositories;

import com.lukinhasssss.casa_do_codigo.entities.Client;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Long> {
}
