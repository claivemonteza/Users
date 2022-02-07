package com.example.demo.access.dto;


import com.example.demo.access.domain.User;
import com.example.demo.access.domain.UserAuthentication;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthenticationDTO {

	private Long userId;
	private String password;
	
	public UserAuthentication toEntity() {
		User user = null;
		if(userId != null) {
			user = new User();
			user.setId(userId);	
		}
		return new UserAuthentication(password, user);
		
	}
}
