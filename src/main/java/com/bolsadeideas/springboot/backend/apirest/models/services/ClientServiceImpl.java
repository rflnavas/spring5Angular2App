package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IClientRepository;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Client;

@Service
public class ClientServiceImpl implements IClientService{

	@Autowired
	IClientRepository clienteRepository;
	
	@Override
	@Transactional(readOnly = true)
	public Iterable<Client> findAll() {
		return clienteRepository.findAll();
	}
	
	public Optional<Client> findById(Long id) {
		return clienteRepository.findById(id);
	}

	@Override
	@Transactional
	public Client save(Client client) {
		return clienteRepository.save(client);
	}

	@Override
	public void deleteById(Long id) {
		clienteRepository.deleteById(id);
	}
	
}
