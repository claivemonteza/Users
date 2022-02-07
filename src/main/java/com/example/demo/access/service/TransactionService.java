package com.example.demo.access.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.example.demo.access.constants.ApiConstants;
import com.example.demo.access.domain.Transaction;
import com.example.demo.access.dto.ResultSaveDTO;
import com.example.demo.access.dto.TransactionDTO;
import com.example.demo.access.repository.TransactionRepository;
import com.example.demo.access.service.wrapper.ListWrapper;
import com.example.demo.exception.DTOListIsEmptyException;
import com.example.demo.util.ExceptionMessageUtil;
import com.example.demo.util.RootException;

@Service
public class TransactionService {
	
	@Autowired
	private TransactionRepository transactionRepository;
	
	
	public Transaction save(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public ListWrapper<ResultSaveDTO> saveList(List<TransactionDTO> transactions){
		List<ResultSaveDTO> resultList = new ArrayList<>();
		ResultSaveDTO resultSaveDTO = null;
		if(transactions.isEmpty()) {
			throw new DTOListIsEmptyException(ApiConstants.LIST_IS_EMPTY_MESSAGE);
		}
		for (TransactionDTO transactionSaveDto : transactions) {
			resultSaveDTO = new ResultSaveDTO();
			Transaction transaction = transactionSaveDto.toEntity();
			Transaction transactionSaved = null;
			try {
				if(transactionSaveDto.getId() != null && transactionSaveDto.getId() > 0) {
					transaction = transactionSaveDto.toEntity(transactionSaveDto.getId());
				}
				transactionSaved =  save(transaction);
				setResultSaveDTO(resultSaveDTO, transactionSaved);
				resultList.add(resultSaveDTO);
			} catch (Exception e) {
				resultSaveDTO.setId(transaction.getId());
				resultSaveDTO.setIntegrated(false);
				resultSaveDTO.setMessage(ExceptionMessageUtil.getFormatedMessage(RootException.getRootExceptionMessage(e)));
				resultList.add(resultSaveDTO);
			}
		}
		return new ListWrapper<ResultSaveDTO>(resultList,transactions.size());
	}
	
	public Transaction update(Transaction transaction) {
		return transactionRepository.save(transaction);
	}
	
	public Transaction get(Long id) {
		return transactionRepository.findById(id).orElseThrow(() -> new EmptyResultDataAccessException("Transaction not found", 1));
	}
	
	public List<Transaction> list(){
		return transactionRepository.findAll();
	}

	
	private void setResultSaveDTO(ResultSaveDTO resultSaveDTO, Transaction transactionSaved) {
		resultSaveDTO.setId(transactionSaved.getId());
		resultSaveDTO.setIntegrated(true);
		resultSaveDTO.setMessage(ApiConstants.SUCCESS_MESSAGE);
	}
}
