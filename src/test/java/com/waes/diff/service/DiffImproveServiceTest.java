package com.waes.diff.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Random;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.waes.diff.request.DiffRequest;
import com.waes.diff.response.DiffResponse;
import com.waes.diff.util.MessagesResponseEnum;

@SpringBootTest
@RunWith(SpringRunner.class)
public class DiffImproveServiceTest {

	@Autowired
	DiffService diffService;

	@Test
	public void shouldPullLeftId() {
		DiffRequest request = new DiffRequest();
		request.setValue(1);
		assertTrue(diffService.pushLeft(1, request));
		assertTrue(diffService.pullLeftId(1));

	}

	@Test
	public void shouldPullRightId() {
		DiffRequest request = new DiffRequest();
		request.setValue(1);
		assertTrue(diffService.pushRight(1, request));
		assertTrue(diffService.pullRightId(1));

	}

	
	@Test
	public void shouldNotPullLeftId() {
		DiffRequest request = new DiffRequest();
		request.setValue(1);
		assertTrue(diffService.pushLeft(1, request));
		assertFalse(diffService.pullLeftId(2));

	}

	@Test
	public void shouldNotPullRightId() {
		DiffRequest request = new DiffRequest();
		request.setValue(1);
		assertTrue(diffService.pushRight(1, request));
		assertFalse(diffService.pullRightId(2));

	}

}
