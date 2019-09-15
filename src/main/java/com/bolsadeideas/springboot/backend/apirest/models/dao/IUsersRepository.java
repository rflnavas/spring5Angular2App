package com.bolsadeideas.springboot.backend.apirest.models.dao;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.User;

public interface IUsersRepository extends CrudRepository<User, Long>{

	@Query("select u from User u where u.username=?1 and u.enabled=true")
	public User findByUsernameActive(String username);
	
	public User findByUsername(String username);
	
	public User findByUsernameAndEmail(String username, String email);
}
