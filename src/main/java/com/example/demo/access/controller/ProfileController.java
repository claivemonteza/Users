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
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.access.domain.Profile;
import com.example.demo.access.dto.ProfileDTO;
import com.example.demo.access.service.ProfileService;

@RestController
@RequestMapping(value="api/v1/profiles")
public class ProfileController {

	@Autowired
	ProfileService profileService;
	
	@GetMapping
	public List<Profile> list(){
		return this.profileService.list();
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<Profile> save(@RequestBody ProfileDTO dto) {
		Profile profile = this.profileService.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(profile);
	}
	
	@PutMapping(value="/update/{id}")
	public Profile update(@RequestBody @Valid ProfileDTO dto, @PathVariable("id") Long id) {
		return this.profileService.edit(dto.toEntity(id));
	}
	
	@GetMapping(value="/find/{id}")
	public Profile findById(@PathVariable("id") Long id) {
		return profileService.get(id);
	}
	
	@DeleteMapping(value="/delete/{id}")
	public void delete(@PathVariable("id") Long id) {
		profileService.delete(id);
	}
	
}
