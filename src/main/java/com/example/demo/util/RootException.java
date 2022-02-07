package com.example.demo.util;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RootException {

	public static String getRootExceptionMessage(Throwable exception) {
		Throwable rootException = exception;
		while (rootException.getCause() != null) {
			rootException = rootException.getCause();
		}
		return rootException.getMessage();
	}
}
