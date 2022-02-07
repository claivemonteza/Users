package com.example.demo.access.domain;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserAuthentication implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private String password;
	private User user;
}
