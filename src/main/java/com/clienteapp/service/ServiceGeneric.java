package com.clienteapp.service;

import java.util.List;
import java.util.Optional;

public interface ServiceGeneric <T, D> {
	
	List<T> getAll();
	
	void save(T t);
	
	Optional<T> findById(D id);
	
	void delete(D id);

}
