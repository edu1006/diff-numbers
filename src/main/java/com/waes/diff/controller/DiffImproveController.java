package com.waes.diff.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.waes.diff.service.DiffService;

@Controller
@RestController
@RequestMapping("improve/add/extend/")
public class DiffImproveController {

	@Autowired
	private final DiffService diffService;

	public DiffImproveController(DiffService diffService) {
		this.diffService = diffService;
	}


	@DeleteMapping(value =   "left/{id}")
	public ResponseEntity<Boolean> pullLeftId(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body( diffService.pullLeftId(id));
	}

	@DeleteMapping(value =   "right/{id}")
	public ResponseEntity<Boolean> pullRightId(@PathVariable("id") Integer id) {
		return ResponseEntity.ok().body( diffService.pullRightId(id));
	}


}
