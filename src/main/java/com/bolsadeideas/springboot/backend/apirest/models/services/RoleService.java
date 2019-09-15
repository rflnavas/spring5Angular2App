package com.bolsadeideas.springboot.backend.apirest.models.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IRoleRepository;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Role;

@Service
public class RoleService implements IRoleService {
	
	@Autowired
	IRoleRepository roleRepository;
	
	@Transactional(readOnly = true)
	public Role findRoleByRolename(String name) {
		return this.roleRepository.findRoleByRolename(name);
	}
}
