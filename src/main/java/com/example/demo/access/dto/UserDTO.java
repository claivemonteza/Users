package com.example.demo.access.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.example.demo.access.core.Language;
import com.example.demo.access.domain.Profile;
import com.example.demo.access.domain.User;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

	@NotBlank(message = "Please enter name")
	private String name;
	
	private String username;
	
	@NotBlank(message = "Please enter email")
	private String email;
	
	@NotBlank(message = "Please enter password")
	private String password;
	
	@NotNull(message = "Please enter profile id")
	private Long profileId;
	
	@NotNull(message = "Please enter a language")
	private Language language;
	
	private boolean active;

	public User toEntity() {
		Profile profile = getProfile(profileId);
		String encoderPassword = new BCryptPasswordEncoder().encode(password);
		return new User(null, name, username, email, encoderPassword, profile, language, true);
	}

	public User toEntity(Long id) {
		Profile profile = getProfile(profileId);
		return new User(id, name, username, email, password, profile, language, active);
	}
	
	private Profile getProfile(Long id) {
		Profile profile = null;
		if(id!=null) {
			profile = new Profile();
			profile.setId(id);	
		}
		return profile;
	}
}
