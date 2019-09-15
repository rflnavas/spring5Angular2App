package com.bolsadeideas.springboot.backend.apirest.controllers;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.validation.BindingResult;
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
import com.bolsadeideas.springboot.backend.apirest.utils.ResponseUtils;

@CrossOrigin(origins = { "http://localhost:4200" }, 
	methods = {RequestMethod.GET,RequestMethod.PUT, RequestMethod.PUT, RequestMethod.DELETE})
@RestController
@RequestMapping(path = "/api")
public class ClientRestController {

	@Autowired
	private IClientService clienteService;

	@RequestMapping(method = RequestMethod.GET, path = "/clients")
	public Iterable<Client> index() {
		return clienteService.findAll();
	}
	
	/**
	 * With the provided annotations along with optional it is possible to show the first page if we type
	 * '/api/clients/page/'
	 */
	@RequestMapping(method = RequestMethod.GET, value  = {"/clients/page/{page}", "/clients/page/"})
	public Page<Client> index(@PathVariable Optional<Integer> page) {
		if(!page.isPresent()) {
			return clienteService.findAll(PageRequest.of(0, 5));
		}
		return clienteService.findAll(PageRequest.of(page.get(), 5));
	}

	@Secured({"ROLE_ADMIN", "ROLE_USER"})
	@GetMapping(path = "/clients/{id}")
	@ResponseStatus(HttpStatus.OK) // Por defecto ya lo hace por lo que es redundante
	public ResponseEntity<?> getClient(@PathVariable long id) {
		Client client;
		try {
			client = clienteService.findById(id).orElseThrow(() -> new ElementNotFound("Client not found"));
			return new ResponseEntity<Client>(client, HttpStatus.OK);
		} catch (ElementNotFound e) {
			Map<String, Object> err = new HashMap<>();
			err.put("message", String.format("Client id %d not found", id));
			return new ResponseEntity<Map<String, Object>>(err, HttpStatus.NOT_FOUND);
		} catch (DataAccessException dae) {
			Map<String, Object> err = new HashMap<>();
			err.put("message", dae.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(err, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PostMapping(path = "/clients")
	@Secured({"ROLE_ADMIN"})
	/*
	 * @Valid:Intercepts the client instance in order to check whether such object is valid
	 * before this method is invoked.
	 */
	public ResponseEntity<?> createClient(@Valid @RequestBody Client client, BindingResult result) {
		/*
		 * Podemos setear la fecha aquí o bien hacemos uso de prePersist del ciclo de
		 * vida de persistencia de la JPA
		 */

		Map<String, Object> response = ResponseUtils.buildValidationErrorResponse(result);
		if (ResponseUtils.hasError(response)) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		Client newClient = null;
		try {
			newClient = clienteService.save(client);
		} catch (DataAccessException dae) {
			response.put("message", "Couldn't create client.");
			response.put("error", dae.getMessage() + ":" + dae.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		} catch (Exception e) {
			response.put("message", "Error");
			response.put("error", e.getMessage() + ":" + e.toString());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("client", newClient);
		response.put("message", "Client succesfully created");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.CREATED);

	}

	@DeleteMapping(path = "/clients/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> deleteClientById(@PathVariable long id) {
		Map<String, Object> response = new HashMap<>();
		try {
			clienteService.deleteById(id);

		} catch (DataAccessException dae) {
			response.put("message", "Couldn't delete client.");
			response.put("error", dae.getMessage() + ":" + dae.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("message", "Client deleted.");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@PutMapping(path = "/clients/{id}")
	@ResponseStatus(HttpStatus.CREATED)
	@Secured({"ROLE_ADMIN"})
	public ResponseEntity<?> updateClient(@Valid @RequestBody Client client, @PathVariable long id,
			BindingResult result) {
		Optional<Client> optClient = clienteService.findById(id);// .orElseThrow(()->new ElementNotFound("There was a
																	// problem updating the client"));
		Map<String, Object> response = new HashMap<>();
		if (!optClient.isPresent()) {
			response.put("message", "Client " + id + " not found");
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
		}

		response = ResponseUtils.buildValidationErrorResponse(result);
		if (ResponseUtils.hasError(response)) {
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.BAD_REQUEST);
		}

		Client currClient = optClient.get();
		currClient.setName(client.getName());
		currClient.setSurname(client.getSurname());
		currClient.setEmail(client.getEmail());

		try {
			currClient = clienteService.save(currClient);
		} catch (DataAccessException dae) {
			response.put("message", "Couldn't update client.");
			response.put("error", dae.getMessage() + ":" + dae.getMostSpecificCause());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
		response.put("value", client);
		response.put("message", "Client succesfully updated");
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
