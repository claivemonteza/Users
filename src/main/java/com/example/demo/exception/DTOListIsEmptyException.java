package com.example.demo.exception;

public class DTOListIsEmptyException extends RuntimeException {

	private static final long serialVersionUID = 1L;
	
	public DTOListIsEmptyException(String message) {
		super(message);
	}

}
