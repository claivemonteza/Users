package com.example.demo.access.dto;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import com.example.demo.access.domain.Profile;
import com.example.demo.access.domain.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ProfileDTO {

	@NotBlank(message = "Please enter a description")
	private String description;
	@NotBlank(message = "Please enter a descriptionEN")
	private String descriptionEN;
	@NotNull(message = "Please select transactions")
	private List<Long> transactionsId;
	private boolean active;
	
	public Profile toEntity() {
		List<Transaction> transactions = gettransactions(transactionsId);
		return new Profile(null, description, descriptionEN, transactions, true);
	}
	
	public Profile toEntity(Long id) {
		List<Transaction> transactions = gettransactions(transactionsId);
		return new Profile(id, description, descriptionEN, transactions, active);
	}
	
	private List<Transaction> gettransactions(List<Long> transactionsId){
		List<Transaction> transactions = new ArrayList<Transaction>();
		for (Long id : transactionsId) {
			if(id!=null) {
				Transaction trans = new Transaction();
				trans.setId(id);
				transactions.add(trans);
			}
		}
		return transactions;
	}
}
