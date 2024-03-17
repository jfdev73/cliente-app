package com.clienteapp.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.clienteapp.entity.Ciudad;
import com.clienteapp.repository.CiudadRepository;

@Service
public class CiudadServiceImpl implements ServiceGeneric<Ciudad, Integer>{
	
	private CiudadRepository ciudadRepository;
	
	public CiudadServiceImpl(CiudadRepository ciudadRepository) {
		this.ciudadRepository = ciudadRepository;
		
	}

	@Override
	public List<Ciudad> getAll() {
		return ciudadRepository.findAll();
	}

	@Override
	public void save(Ciudad ciudad) {
		ciudadRepository.save(ciudad);
	}

	@Override
	public Optional<Ciudad> findById(Integer id) {
		return ciudadRepository.findById(id);
	}

	@Override
	public void delete(Integer id) {
	ciudadRepository.deleteById(id);
		
	}

}
