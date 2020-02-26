package com.waes.diff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.waes.diff.request.DiffRequest;
import com.waes.diff.response.DiffResponse;
import com.waes.diff.service.DiffService;

@Controller
@RestController
@RequestMapping("v1/diff/")
public class DiffController {

	@Autowired
	private final DiffService diffService;

	public DiffController(DiffService diffService) {
		this.diffService = diffService;
	}

	@RequestMapping(value = "/{id}/left", produces = "application/json", method = { RequestMethod.POST })
	@ResponseStatus(value = HttpStatus.CREATED, reason = "pushed left")
	public ResponseEntity<Object> pushLeft(@PathVariable("id") Integer id, @RequestBody DiffRequest request) {
		return ResponseEntity.ok().body(diffService.pushLeft(id, request)); 
	}

	@RequestMapping(value = "/{id}/right", produces = "application/json", method = { RequestMethod.POST })
	@ResponseStatus(value = HttpStatus.CREATED, reason = "pushed right")
	public ResponseEntity<Boolean> pushRight(@PathVariable("id") Integer id, @RequestBody DiffRequest request) {
		return ResponseEntity.ok().body(diffService.pushRight(id, request));
	}

	@RequestMapping(value = "{id}", produces = "application/json", method = { RequestMethod.GET })
//	@ResponseStatus(value = HttpStatus.OK, reason = "geted diff")
	public ResponseEntity<DiffResponse> getDiff(@PathVariable("id") Integer id) {
		DiffResponse response = diffService.getDiff(id);
		return ResponseEntity.ok().body(response);
	}

}
