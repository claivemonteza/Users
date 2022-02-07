package com.example.demo.access.repository.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.access.domain.User;
import com.example.demo.access.repository.query.UserRepositoryQuery;

public class UserRepositoryImpl implements UserRepositoryQuery {

	@PersistenceContext
	private EntityManager entityManager;
	
	@Override
	public boolean login(User user, String password) {
		return new BCryptPasswordEncoder().matches(password, user.getPassword());
	}

}
