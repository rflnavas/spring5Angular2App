package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.entity.User;

public interface IUserService {
	User findByUsername(String username);
	User save(User user);
}
