package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Client;

public interface IClientService {
	
	Optional<Client> findById(Long id);
	Iterable<Client> findAll();
	Page<Client> findAll(Pageable pageable);
	Client save(Client c);
	void deleteById(Long id);
	
}
