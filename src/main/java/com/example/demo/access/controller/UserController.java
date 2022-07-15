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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.access.domain.User;
import com.example.demo.access.domain.UserAuthentication;
import com.example.demo.access.dto.AuthenticationDTO;
import com.example.demo.access.dto.UserDTO;
import com.example.demo.access.response.UserResponseDTO;
import com.example.demo.access.service.UserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;


@RestController
@RequestMapping(value="api/v1/users")
public class UserController {

	@Autowired
	UserService userService;
	
	
	@Operation(summary="Get users", description="Get a list of users",tags="User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="List of users"),
			@ApiResponse(responseCode = "404", description="Not found")
	})
	@GetMapping
	public List<User> list(){
		return this.userService.list();
	}
	
	
	@Operation(summary="Save user", description="Will save user",tags="User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", description="Save successfully"),
			@ApiResponse(responseCode = "400", description="Duplicate user")
	})
	@PostMapping(value="/save")
	public ResponseEntity<UserResponseDTO> save(@RequestBody UserDTO dto) {
		UserResponseDTO urd = new UserResponseDTO(this.userService.save(dto.toEntity()));
		return ResponseEntity.status(HttpStatus.CREATED).body(urd);
	}
	
	
	@Operation(summary="Update user", description="Will update users",tags="User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="Update successfully"),
			@ApiResponse(responseCode = "400", description="Bad Request")
	})
	@PutMapping(value="/update/{id}")
	public User update(@RequestBody UserDTO dto, @PathVariable("id") Long id) {
		return this.userService.edit(dto.toEntity(id));
	}
	
	
	@Operation(summary="Find by id", description="Will search user by id",tags="User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="search user that have id"),
			@ApiResponse(responseCode = "400", description="Not found")
	})
	@GetMapping(value="/find/{id}")
	public User findById(@PathVariable("id") Long id) {
		return userService.get(id);
	}
	
	@Operation(summary="Delete user", description="Will remove user",tags="User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "204", description="Delete successfully"),
			@ApiResponse(responseCode = "400", description="Not found")
	})
	@DeleteMapping(value="/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		userService.delete(id);
	}
	
	@Operation(summary="Search by name ou username", description="Will remove user",tags="User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "204", description="Delete successfully"),
			@ApiResponse(responseCode = "400", description="Not found")
	})
	@GetMapping(value="/search/{text}")
	public List<User> search( @PathVariable("text") String text){
		return this.userService.search(text);
	}

	
	@Operation(summary="Login", description="Will insert username and password to access",tags="User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "202", description="Login successfully"),
			@ApiResponse(responseCode = "404", description="Username or password invalid")
	})
	@GetMapping(value = "/login")
	public ResponseEntity<User> login(@RequestParam("username") String username,
			@RequestParam("password") String password) {
		Optional<User> user = this.userService.findByUsername(username);
		boolean check = this.userService.login(password, user.get());
		if (check) {
			return ResponseEntity.status(HttpStatus.ACCEPTED).body(user.get());
		}

		return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
	}

	
	@Operation(summary="Authentication", description="Will insert username and password to access",tags="User")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "202", description="Login successfully"),
			@ApiResponse(responseCode = "404", description="Username or password invalid")
	})
	@GetMapping(value = "/authentication")
	public ResponseEntity<Boolean> authentication(@RequestBody AuthenticationDTO dto) {
		UserAuthentication ua = dto.toEntity();
		ua.setUser(this.userService.get(ua.getUser().getId()));
		boolean check = this.userService.login(ua.getPassword(), ua.getUser());
		return ResponseEntity.status(HttpStatus.ACCEPTED).body(check);
	}
}
