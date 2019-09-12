package com.bolsadeideas.springboot.backend.apirest.models.services;

import java.util.Collection;
import java.util.stream.Collectors;

import org.springframework.transaction.annotation.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IUsersRepository;
import com.bolsadeideas.springboot.backend.apirest.models.entity.User;

@Service
public class UserServiceImpl implements UserDetailsService, IUsuarioService {

	private Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
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
		
		System.out.println(user.getRoles().iterator().next().getRolename());
		Collection<GrantedAuthority> authorities = user.getRoles().stream()
				.map(r -> new SimpleGrantedAuthority(r.getRolename())).peek(r -> logger.info(r.getAuthority()))
				.collect(Collectors.toList());

		return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
				user.isEnabled(), true, true, true, authorities);

	}

	@Override
	public User findByUsername(String username) {
		return userRepository.findByUsernameActive(username);
	}
}
