package com.waes.diff.response;

import java.util.List;

public class DiffResponse {

	private String message; 
	private List<Integer> data;

	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public List<Integer> getData() {
		return data;
	}
	public void setData(List<Integer> data) {
		this.data = data;
	} 
	
}
