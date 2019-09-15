package com.bolsadeideas.springboot.backend.apirest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.bolsadeideas.springboot.backend.apirest.config.JWTConfigProperties;
import com.bolsadeideas.springboot.backend.apirest.models.entity.Role;
import com.bolsadeideas.springboot.backend.apirest.models.entity.User;
import com.bolsadeideas.springboot.backend.apirest.models.services.IRoleService;
import com.bolsadeideas.springboot.backend.apirest.models.services.IUserService;

@SpringBootApplication
public class SpringBootBackendApirestApplication implements CommandLineRunner {

	private final Logger log = LoggerFactory.getLogger(SpringBootBackendApirestApplication.class);
	
	@Autowired
	private IUserService userService;
	
	@Autowired
	private IRoleService roleService;
	
	@Autowired
	JWTConfigProperties jwtConfigProps;
	
	public static void main(String[] args) {
		SpringApplication.run(SpringBootBackendApirestApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user = new User("rafa", "12345", "rafa navas", "rafanavas@mail.com");
		Role role = roleService.findRoleByRolename("ROLE_USER");
		user.addRole(role);
		User savedUser = userService.save(user);
		log.debug("====> user saved as " + savedUser);
		
//		User userAdmin = new User("admin", "abcdef", "AdminApp", "admin@mail.com");
//		Role roleAdmin = roleService.findRoleByRolename("ROLE_ADMIN");
//		userAdmin.addRole(roleAdmin);
//		User savedAdmin = userService.save(userAdmin);
//		log.debug("====> user saved as " + savedAdmin);
		System.out.println(jwtConfigProps.getSecretKey()); 
		System.out.println(jwtConfigProps.getPrivateKey());
		System.out.println(jwtConfigProps.getPublicKey());
	}

}
