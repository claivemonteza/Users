package com.example.demo.access.service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.access.core.IService;
import com.example.demo.access.domain.Profile;
import com.example.demo.access.domain.Transaction;
import com.example.demo.access.repository.ProfileRepository;

@Service
public class ProfileService implements IService<Profile>{
	@Autowired
	private ProfileRepository profileRepository;
	
	@Autowired
	private TransactionService transactionService;
	
	@Override
	public Profile save(Profile profile) {
		profile.setTransactions(getTransactions(profile.getTransactions()));
		return profileRepository.save(profile);
	}
	
	@Override
	public Profile edit(Profile profile) {
		profile.setTransactions(getTransactions(profile.getTransactions()));
		return profileRepository.save(profile);
	}
	
	@Override
	public Profile get(Long id) {
		return profileRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Profile not found", 1));
	}
	
	@Override
	public List<Profile> list(){
		return profileRepository.findAll();
	}

	@Override
	public void delete(Long t) {
		profileRepository.deleteById(t);
	}
	
	private List<Transaction> getTransactions(List<Transaction> transactions){
		List<Transaction> newTransactions = new ArrayList<>();		
		newTransactions.addAll(transactions.stream().map(t -> {
			Transaction transaction = transactionService.get(t.getId());
			return transaction;
		}).collect(Collectors.toList()));
		return newTransactions;
	}

}
