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

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;

@RestController
@RequestMapping(value="api/v1/transactions")
public class TransactionController {

	@Autowired
	TransactionService transactionService;
	
	
	@Operation(summary="Get transactions", description="Get a list of transactions",tags="Transaction")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="List of transactions"),
			@ApiResponse(responseCode = "404", description="Not found")
	})
	@GetMapping
	public List<Transaction> list(){
		return this.transactionService.list();
	}
	
	
	@Operation(summary="Save transaction", description="Will save transaction",tags="Transaction")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", description="Save successfully"),
			@ApiResponse(responseCode = "400", description="Duplicate transaction")
	})
	@PostMapping(value="/save")
	public ResponseEntity<Transaction> save(@RequestBody @Valid TransactionDTO dto) {
		Transaction transactionSave = transactionService.save(dto.toEntity());
		return ResponseEntity.status(HttpStatus.CREATED).body(transactionSave);
	}
	
	
	@Operation(summary="Save transactions", description="Will save transactions",tags="Transaction")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "201", description="Save successfully"),
			@ApiResponse(responseCode = "400", description="Duplicate transaction")
	})
	@PostMapping(value="/save/list")
	public ResponseEntity<List<ResultSaveDTO>> saveList(@RequestBody @Valid List<TransactionDTO> dtos){
		ListWrapper<ResultSaveDTO> listWrapper = transactionService.saveList(dtos);
		return listWrapper.isAllSaved() ? ResponseEntity.status(HttpStatus.CREATED).body(listWrapper.getResultList())
				: ResponseEntity.badRequest().body(listWrapper.getResultList());
	}

	
	@Operation(summary="Update transaction", description="Will update transaction",tags="Transaction")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="Update successfully"),
			@ApiResponse(responseCode = "400", description="Bad Request")
	})
	@PutMapping(value="/update/{id}")
	public Transaction update(@RequestBody @Valid TransactionDTO dto, @PathVariable("id")Long id) {
		return transactionService.save(dto.toEntity(id));
	}
	
	@Operation(summary="Find by id", description="Will search transaction by id",tags="Transaction")
	@ApiResponses(value= {
			@ApiResponse(responseCode = "200", description="search transaction that have id"),
			@ApiResponse(responseCode = "400", description="Not found")
	})
	@GetMapping(value="/find/{id}")
	public Transaction findById(@PathVariable("id")Long id) {
		return transactionService.get(id);
	}
}
