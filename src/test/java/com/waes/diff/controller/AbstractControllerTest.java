package com.waes.diff.controller;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.google.gson.Gson;
import com.waes.diff.service.DiffService;

@RunWith(SpringRunner.class)
@WebMvcTest
public abstract class AbstractControllerTest {

	@Autowired
	protected MockMvc mockMvc;

	@MockBean
	protected DiffService diffService;
	final Gson gson; 

	public AbstractControllerTest() {
		gson = new Gson(); 
	}
	
	protected synchronized String objectToJson(Object value) {
		return this.gson.toJson(value);  
	}

}
