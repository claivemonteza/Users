package com.example.demo.access.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import com.example.demo.access.domain.User;
import com.example.demo.access.repository.query.UserRepositoryQuery;

public interface UserRepository extends JpaRepository<User, Long>, UserRepositoryQuery, JpaSpecificationExecutor<User> {

}
