package com.example.demo.access.response;

import com.example.demo.access.core.Language;
import com.example.demo.access.domain.Profile;
import com.example.demo.access.domain.User;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
	
	private Long id;
	private String name;
	private String username;
	private String email;
	//@JsonIgnoreProperties({"transactions","active"})
	@JsonIgnoreProperties({"transactions"})
	private Profile profile;
	private Language language;
	//@JsonIgnore()
	private boolean active;
	
	public UserResponseDTO(User user){
		this.setId(user.getId());
		this.setName(user.getName());
		this.setUsername(user.getUsername());
		this.setEmail(user.getEmail());
		this.setProfile(user.getProfile());
		this.setLanguage(user.getLanguage());
		this.setActive(user.isActive());
	}
	
}
