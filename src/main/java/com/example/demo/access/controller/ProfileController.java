package com.example.demo.access.controller;

import java.util.List;

import javax.validation.Valid;

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
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.access.domain.Profile;
import com.example.demo.access.dto.ProfileDTO;
import com.example.demo.access.service.ProfileService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value="api/v1/profiles")
public class ProfileController {

	@Autowired
	ProfileService profileService;
	
	
	@Operation(summary="Get profiles", description="Get a list of profiles",tags="Profile")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="List of profiles"),
			@ApiResponse(responseCode = "404", description="Not found")
	})
	@GetMapping
	public List<Profile> list(){
		return this.profileService.list();
	}
	
	
	@Operation(summary="Save profile", description="Will save profile",tags="Profile")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", description="Save successfully"),
			@ApiResponse(responseCode = "400", description="Duplicate profile")
	})
	@PostMapping(value="/save")
	public ResponseEntity<Profile> save(@RequestBody ProfileDTO dto) {
		Profile profile = this.profileService.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(profile);
	}
	
	
	@Operation(summary="Update profile", description="Will update profile",tags="Profile")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="Update successfully"),
			@ApiResponse(responseCode = "400", description="Bad Request")
	})
	@PutMapping(value="/update/{id}")
	public Profile update(@RequestBody @Valid ProfileDTO dto, @PathVariable("id") Long id) {
		return this.profileService.edit(dto.toEntity(id));
	}
	
	
	@Operation(summary="Find by id", description="Will search profile by id",tags="Profile")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="search profile that have id"),
			@ApiResponse(responseCode = "400", description="Not found")
	})
	@GetMapping(value="/find/{id}")
	public Profile findById(@PathVariable("id") Long id) {
		return profileService.get(id);
	}
	
	
	@Operation(summary="Delete profile", description="Will remove profile",tags="Profile")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "204", description="Delete successfully"),
			@ApiResponse(responseCode = "400", description="Not found")
	})
	@DeleteMapping(value="/delete/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void delete(@PathVariable("id") Long id) {
		profileService.delete(id);
	}
	
}
