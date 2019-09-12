package com.bolsadeideas.springboot.backend.apirest.models.services;

import org.springframework.security.core.userdetails.UserDetails;

public interface IUserService {
	
	UserDetails findByUsername(String username);
}
