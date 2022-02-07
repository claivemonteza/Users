package com.example.demo.util;

public class ExceptionMessageUtil {
	
	public static String getFormatedMessage(String message){
		return message.replace("dbo.", "");
	}
}
