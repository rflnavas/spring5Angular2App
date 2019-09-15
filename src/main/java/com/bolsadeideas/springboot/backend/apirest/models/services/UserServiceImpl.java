package com.bolsadeideas.springboot.backend.apirest.models.services;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.bolsadeideas.springboot.backend.apirest.models.dao.IUsersRepository;
import com.bolsadeideas.springboot.backend.apirest.models.entity.User;

@Service
public class UserServiceImpl implements IUserService {

	@Autowired
	BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private IUsersRepository userRepository;

	@Override
	@Transactional(readOnly = true)
	public User findByUsername(String username) {
		return userRepository.findByUsernameActive(username);
	}

	@Override
	public User save(User user) {
		user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
		return userRepository.save(user);
	}
}
