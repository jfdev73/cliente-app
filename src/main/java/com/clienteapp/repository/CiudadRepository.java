package com.clienteapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clienteapp.entity.Ciudad;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

}
