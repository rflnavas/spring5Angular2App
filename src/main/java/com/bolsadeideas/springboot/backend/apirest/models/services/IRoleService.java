package com.bolsadeideas.springboot.backend.apirest.models.services;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Role;

public interface IRoleService {
	
	Role findRoleByRolename(String name);
}
