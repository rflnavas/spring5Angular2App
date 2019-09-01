package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.Optional;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Client;

public interface IClientService {
	
	Optional<Client> findById(Long id);
	Iterable<Client> findAll();
	Client save(Client c);
	void deleteById(Long id);
	
}
