package com.example.demo.access.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.access.domain.Transaction;
import com.example.demo.access.dto.ResultSaveDTO;
import com.example.demo.access.dto.TransactionDTO;
import com.example.demo.access.service.TransactionService;
import com.example.demo.access.service.wrapper.ListWrapper;

@RestController
@RequestMapping(value="api/v1/transactions")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	@GetMapping
	public List<Transaction> list(){
		return this.transactionService.list();
	}
	
	@PostMapping(value="/save")
	public ResponseEntity<Transaction> save(@RequestBody @Valid TransactionDTO dto) {
		Transaction transactionSave = transactionService.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionSave);
	}
	
	@PostMapping(value="/save/list")
	public ResponseEntity<List<ResultSaveDTO>> saveList(@RequestBody @Valid List<TransactionDTO> dtos){
		ListWrapper<ResultSaveDTO> listWrapper = transactionService.saveList(dtos);
		return listWrapper.isAllSaved() ? ResponseEntity.status(HttpStatus.CREATED).body(listWrapper.getResultList())
				: ResponseEntity.badRequest().body(listWrapper.getResultList());
	}

	@PutMapping(value="/update/{id}")
	public Transaction update(@RequestBody @Valid TransactionDTO dto, @PathVariable("id")Long id) {
		return transactionService.save(dto.toEntity(id));
	}
	
	@GetMapping(value="/find/{id}")
	public Transaction findById(@PathVariable("id")Long id) {
		return transactionService.get(id);
	}
}
