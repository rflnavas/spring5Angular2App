package com.bolsadeideas.springboot.backend.apirest.models.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.bolsadeideas.springboot.backend.apirest.models.entity.Role;

@Repository
public interface IRoleRepository extends CrudRepository<Role, Long>{
	
	Role findRoleByRolename(String name);
}
