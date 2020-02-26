package com.waes.diff.controller;

import static org.mockito.Mockito.when;
import static org.springframework.http.MediaType.APPLICATION_JSON_UTF8;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;

import com.waes.diff.request.DiffRequest;

@RunWith(SpringRunner.class)
@WebMvcTest
public class DiffControllerTest extends AbstractControllerTest {

	@Test
	public void shouldPushLeft() throws Exception {
		//when
		when(diffService.pushLeft(Mockito.anyInt(), Mockito.any())).thenReturn(Boolean.TRUE);

		DiffRequest request = new DiffRequest(); 
		
		// then
		mockMvc.perform(post("/v1/diff/11/left")
				.content(objectToJson(request))
				.contentType(APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());


	}

	
	@Test
	public void shouldPushRight() throws Exception {
		//when
		when(diffService.pushRight(Mockito.anyInt(), Mockito.any())).thenReturn(Boolean.TRUE);

		DiffRequest request = new DiffRequest(); 
		
		// then
		mockMvc.perform(post("/v1/diff/11/right")
				.content(objectToJson(request))
				.contentType(APPLICATION_JSON_UTF8)
				.accept(MediaType.APPLICATION_JSON))
				.andExpect(status().isCreated());


	}

	@Test
	public void diff() throws Exception {

		// then
		mockMvc.perform(get("/v1/diff/11").accept(MediaType.APPLICATION_JSON)).andExpect(status().isOk()); 

	}

}
