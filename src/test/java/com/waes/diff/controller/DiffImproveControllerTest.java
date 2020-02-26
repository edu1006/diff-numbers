package com.waes.diff.controller;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import com.waes.diff.request.DiffRequest;

public class DiffImproveControllerTest extends AbstractControllerTest {
	@Autowired
	DiffController diff; 

	@Autowired
	DiffImproveController improve; 
	@Test
	public void shouldPUllLeft() throws Exception {
		DiffRequest request = new DiffRequest(1);
		when(diffService.pushLeft(Mockito.anyInt(), Mockito.any())).thenReturn(Boolean.TRUE);
		when(diffService.pullLeftId(Mockito.anyInt())).thenReturn(Boolean.TRUE);

		diff.pushLeft(1, request );
		ResponseEntity<Boolean> isPulled = improve.pullLeftId(1);
		assertTrue(isPulled.getBody());
	}



	@Test
	public void shouldPullRight() throws Exception {
		DiffRequest request = new DiffRequest(1);
		when(diffService.pushRight(Mockito.anyInt(), Mockito.any())).thenReturn(Boolean.TRUE);
		when(diffService.pullRightId(Mockito.anyInt())).thenReturn(Boolean.TRUE);

		diff.pushRight(1, request );
		ResponseEntity<Boolean> isPulled = improve.pullRightId(1);
		assertTrue(isPulled.getBody());
	}

}
