package com.waes.diff.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Random;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
public class DiffServiceTest {

	@Autowired
	DiffService diffService;

	@Test
	public void shouldPushLeft() {
		DiffRequest request = new DiffRequest();
		request.setValue(1);
		assertTrue(diffService.pushLeft(1, request));
	}

	@Test
	public void shouldPushRight() {
		DiffRequest request = new DiffRequest();
		request.setValue(1);
		assertTrue(diffService.pushRight(1, request));
	}

	public void getDiff() {
		diffService.getDiff(1);
	}

	@Test
	public void shouldBeDifferenceBetweenLeftAndRightEmpty() {
		Random r = new Random();
		this.diffService = new DiffService();

		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				diffService.pushRight(1, new DiffRequest(r.nextInt(1)));
			} else {
				diffService.pushLeft(1, new DiffRequest(r.nextInt(1)));
			}
		}
		DiffResponse response = diffService.getDiff(1);
		assertEquals(response.getMessage(), MessagesResponseEnum.IS_EQUAL.getMessage());
		assertTrue(response.getData().isEmpty());

	}

	@Test
	public void shouldPushLeftAndRight() {
		Random r = new Random();
		this.diffService = new DiffService();
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				diffService.pushRight(1, new DiffRequest(r.nextInt(100)));
			} else {
				diffService.pushLeft(1, new DiffRequest(r.nextInt(100)));
			}
		}
		DiffResponse response = diffService.getDiff(1);
		assertEquals(response.getMessage(), MessagesResponseEnum.IS_EQUAL.getMessage());
		assertFalse(response.getData().isEmpty());

	}

	@Test
	public void shouldLeftBeBigger() {
		Random r = new Random();
		this.diffService = new DiffService();
		for (int i = 0; i < 89; i++) {
			if (i % 2 == 0) {
				diffService.pushLeft(1, new DiffRequest(r.nextInt(100)));
			} else {
				diffService.pushRight(1, new DiffRequest(r.nextInt(100)));
			}
		}
		DiffResponse response = diffService.getDiff(1);
		assertEquals(response.getMessage(), MessagesResponseEnum.IS_LEFT_BIGGER.getMessage());
		assertFalse(response.getData().isEmpty());
	}

	@Test
	public void shouldRightBeBigger() {
		Random r = new Random();
		this.diffService = new DiffService();
		for (int i = 0; i < 67; i++) {
			if (i % 2 == 0) {
				diffService.pushRight(1, new DiffRequest(r.nextInt(100)));
			} else {
				diffService.pushLeft(1, new DiffRequest(r.nextInt(100)));

			}
		}
		DiffResponse response = diffService.getDiff(1);
		assertEquals(response.getMessage(), MessagesResponseEnum.IS_RIGHT_BIGGER.getMessage());
		assertFalse(response.getData().isEmpty());

	}

	@Test
	public void shouldPushLeftAndRightWithdifferentIds() {
		Random r = new Random();
		this.diffService = new DiffService();
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				diffService.pushRight(i, new DiffRequest(r.nextInt(100)));
			} else {
				diffService.pushLeft(i, new DiffRequest(r.nextInt(100)));
			}
		}
	

		DiffResponse response = null;
		for (int i = 0; i < 4; i++) {
			if (i % 2 == 0) {
				response = diffService.getDiff(i);
				assertEquals(response.getMessage(), MessagesResponseEnum.IS_RIGHT_BIGGER.getMessage());
				assertFalse(response.getData().isEmpty());
			
			} else {
				response = diffService.getDiff(i);
				assertEquals(response.getMessage(), MessagesResponseEnum.IS_LEFT_BIGGER.getMessage());
				assertFalse(response.getData().isEmpty());

			}
		}

		
		

	}


}
