package com.clienteapp.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.clienteapp.entity.Cliente;
import com.clienteapp.repository.ClienteRepository;

@Service
public class ClienteServiceImpl implements ServiceGeneric<Cliente, Long> {
	
	private ClienteRepository clienteRepository;
	
	public ClienteServiceImpl(ClienteRepository clienteRepository) {
		
		this.clienteRepository = clienteRepository;
		
	}

	@Override
	public List<Cliente> getAll() {
		return clienteRepository.findAll();
	}
	
	@Transactional
	@Override
	public void save(Cliente cliente) {
		clienteRepository.save(cliente);
		
	}

	@Override
	public Optional<Cliente> findById(Long id) {
		return clienteRepository.findById(id);
	}
	
	@Transactional
	@Override
	public void delete(Long id) {
		clienteRepository.deleteById(id);
		
	}

}
