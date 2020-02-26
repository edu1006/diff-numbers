package com.waes.diff.util;

public enum MessagesResponseEnum {
	IS_EQUAL("elements are equals "),
	IS_LEFT_BIGGER("elements are not equals,  LEFT list is bigger"),
	IS_RIGHT_BIGGER("elements are not equals, RIGHT list is bigger"); 	
	
	private String message;
	
	MessagesResponseEnum (String message){
		this.message = message; 
	}
	
	public String getMessage() {
		return message;
	}
}
