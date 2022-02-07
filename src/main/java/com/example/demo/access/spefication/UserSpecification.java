package com.example.demo.access.spefication;

import javax.persistence.criteria.Predicate;

import org.springframework.data.jpa.domain.Specification;

import com.example.demo.access.domain.User;

public class UserSpecification {

	public static Specification<User> search(String text){
		if(text == null) {
			return  null;
		}
		String pattern = "%" + text + "%";
		return (root, query, cb)->{
			Predicate nameUsername = cb.or(cb.like(root.get("name"), pattern), cb.like(root.get("username"), pattern), cb.like(root.get("email"), pattern));
			return nameUsername;
		};
		
	}
}
