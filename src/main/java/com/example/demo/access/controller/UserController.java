package com.example.demo.access.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.access.domain.User;
import com.example.demo.access.domain.UserAuthentication;
import com.example.demo.access.dto.AuthenticationDTO;
import com.example.demo.access.dto.UserDTO;
import com.example.demo.access.response.UserResponseDTO;
import com.example.demo.access.service.UserService;


@RestController
@RequestMapping(value="api/v1/users")
public class UserController {

	@Autowired
	UserService userService;
	
	@GetMapping
	public List<User> list(){
		return this.userService.list();
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<UserResponseDTO> save(@RequestBody UserDTO dto) {
		UserResponseDTO urd = new UserResponseDTO(this.userService.save(dto.toEntity()));
		return ResponseEntity.status(HttpStatus.CREATED).body(urd);
	}
	
	@PutMapping(value="/update/{id}")
	public User update(@RequestBody UserDTO dto, @PathVariable("id") Long id) {
		return this.userService.edit(dto.toEntity(id));
	}
	
	@GetMapping(value="/find/{id}")
	public User findById(@PathVariable("id") Long id) {
		return userService.get(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
	
	@GetMapping(value="/search/{text}")
	public List<User> search( @PathVariable("text") String text){
		return this.userService.search(text);
	}

	@GetMapping(value = "/login")
	public ResponseEntity<User> login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		Optional<User> user = this.userService.findByUsername(username);
		boolean check = this.userService.login(password, user.get());
		if (check) {
			return ResponseEntity.status(HttpStatus.CREATED).body(user.get());
		}

		return ResponseEntity.status(HttpStatus.CREATED).body(user.get());
	}

	@GetMapping(value = "/authentication")
	public ResponseEntity<Boolean> authentication(@RequestBody AuthenticationDTO dto) {
		UserAuthentication ua = dto.toEntity();
		ua.setUser(this.userService.get(ua.getUser().getId()));
		boolean check = this.userService.login(ua.getPassword(), ua.getUser());
		return ResponseEntity.status(HttpStatus.CREATED).body(check);
	}
}
