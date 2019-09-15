package com.bolsadeideas.springboot.backend.apirest.auth;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IUsersRepository;
import com.bolsadeideas.springboot.backend.apirest.models.entity.User;

@Service
public class AppUserDetailsService implements UserDetailsService{

	private Logger logger = LoggerFactory.getLogger(AppUserDetailsService.class);
	@Autowired
	private IUsersRepository userRepository;
	
	@Override
	@Transactional(readOnly=true) //This prevents the infamous org.hibernate.LazyInitializationException
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userRepository.findByUsernameActive(username);
		if (user == null) {
			final String errMsg = String.format("El usuario '%s' no existe", username);
			logger.error(errMsg);
			throw new UsernameNotFoundException(errMsg);
		}
		return new AppUserDetails(user);
	}
}
