package com.clienteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clienteapp.entity.Cliente;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

}
