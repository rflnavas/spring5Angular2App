package com.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Client;

public interface IClientRepository extends CrudRepository<Client, Long>{
	
	//As a reference https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	@Query("select c from Client c where c.email = ?1")
	Client findByEmail(String email);
	Iterable<Client> findByNameContainingIgnoreCase(String name);
	Iterable<Client> findByCreatedAtBetween(Date from, Date to);
}
