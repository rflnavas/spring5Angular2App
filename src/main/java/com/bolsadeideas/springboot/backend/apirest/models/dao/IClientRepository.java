package com.bolsadeideas.springboot.backend.apirest.models.dao;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Client;

public interface IClientRepository extends JpaRepository<Client, Long>{
	
	//As a reference https://docs.spring.io/spring-data/jpa/docs/current/reference/html/#jpa.query-methods
	@Query("select c from Client c where c.email = ?1")
	Client findByEmail(String email);
	Iterable<Client> findByNameContainingIgnoreCase(String name);
	Iterable<Client> findByCreatedAtBetween(Date from, Date to);
}
