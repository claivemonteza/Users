package com.example.demo.access.dto;

import javax.validation.constraints.NotBlank;

import com.example.demo.access.domain.Transaction;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class TransactionDTO {

	private Long id;
	@NotBlank(message = "Please enter a description")
	private String description;
	@NotBlank(message = "Please enter a descriptionEN")
	private String descriptionEN;

	public Transaction toEntity() {
		return new Transaction(null, description, descriptionEN);
	}
	
	public Transaction toEntity(Long id) {
		return new Transaction(id, description, descriptionEN);
	}

}
