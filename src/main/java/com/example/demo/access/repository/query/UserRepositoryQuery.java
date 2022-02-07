package com.example.demo.access.repository.query;

import com.example.demo.access.domain.User;

public interface UserRepositoryQuery {

	public boolean login(User user, String password);
}
