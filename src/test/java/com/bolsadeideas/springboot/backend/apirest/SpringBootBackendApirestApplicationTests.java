package com.bolsadeideas.springboot.backend.apirest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.test.context.junit4.SpringRunner;

import com.bolsadeideas.springboot.backend.apirest.config.JWTConfigProperties;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootBackendApirestApplicationTests {

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Autowired
	JWTConfigProperties props;
	@Test
	public void contextLoads() {
		System.out.println(props.getSecretKey()); 
		System.out.println(passwordEncoder.encode("admin123"));
	}

}
