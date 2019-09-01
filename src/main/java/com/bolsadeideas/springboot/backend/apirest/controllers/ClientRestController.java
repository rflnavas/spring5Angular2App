package com.bolsadeideas.springboot.backend.apirest.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.bolsadeideas.springboot.backend.apirest.exceptions.ElementNotFound;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Client;
import com.bolsadeideas.springboot.backend.apirest.models.services.IClientService;

@CrossOrigin(origins= {"http://localhost:4200"})
@RestController
@RequestMapping(path = "/api")
public class ClientRestController {
	
	@Autowired
	private IClientService clienteService;
	
	@RequestMapping(method = RequestMethod.GET, path = "/clients")
	public Iterable<Client> index(){
		return clienteService.findAll();
	}
	
	@GetMapping(path="/clients/{id}")
	@ResponseStatus(HttpStatus.OK) //Por defecto ya lo hace por lo que es redundante
	public Client getClient(@PathVariable long id) {
		return clienteService.findById(id).orElseThrow(()-> new ElementNotFound("No se encontró el cliente"));
	}
	
	@PostMapping(path="/clients")
	@ResponseStatus(HttpStatus.CREATED) //Para devolver un 201 si todo fue bien
	public Client createClient(@RequestBody Client client) {
		/*
		 * Podemos setear la fecha aquí o bien hacemos uso de prePersist del ciclo de vida de persistencia de la JPA 
		 */
		//client.setCreatedAt(new Date()); 
		return clienteService.save(client);
	}
	
	@DeleteMapping(path="/clients/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void deleteClientById(@PathVariable long id) {
		clienteService.deleteById(id);
	}
	
	@PutMapping(path="/clients/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	public Client updateClient(@RequestBody Client client, @PathVariable long id) {
		Client currentClient = clienteService.findById(id).orElseThrow(()->new ElementNotFound("There was a problem updating the client"));
		currentClient.setName(client.getName());
		currentClient.setSurname(client.getSurname());
		currentClient.setEmail(client.getEmail());
		return clienteService.save(currentClient);
	}
	
}
