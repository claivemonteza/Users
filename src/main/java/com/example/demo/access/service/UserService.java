package com.example.demo.access.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.example.demo.access.core.IService;
import com.example.demo.access.domain.Profile;
import com.example.demo.access.domain.User;
import com.example.demo.access.repository.UserRepository;
import com.example.demo.access.spefication.UserSpecification;



@Service
public class UserService implements IService<User>{
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private ProfileService profileService;
	
	@Override
	public User save(User user) {
		Profile profile = profileService.get(user.getProfile().getId());
		user.setProfile(profile);
		return userRepository.save(user);
	}
	
	@Override
	public User edit(User user) {
		Profile profile = profileService.get(user.getProfile().getId());
		user.setProfile(profile);
		return userRepository.save(user);
	}
	
	@Override
	public User get(Long id) {
		return userRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("User not found", 1));
	}
	
	@Override
	public List<User> list(){
		return userRepository.findAll();
	}


	@Override
	public void delete(Long t) {
		userRepository.deleteById(t);
	}
	
	public Optional<User> findByUsername(String username) {
		Specification<User> spec = UserSpecification.search(username);
		return Optional.of(userRepository.findOne(spec).orElseThrow(() -> new EmptyResultDataAccessException("username or password invalid!!!", 1)));
	}
	
	public List<User> search(String text){
		Specification<User> spec = UserSpecification.search(text);
		return userRepository.findAll(spec);
	}
	

	public boolean login(String password, User user) {
		return new BCryptPasswordEncoder().matches(password, user.getPassword());
	}
}
