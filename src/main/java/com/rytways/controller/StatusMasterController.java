package com.rytways.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rytways.model.StatusMaster;
import com.rytways.service.StatusService;

@RequestMapping("/status")
@RestController
public class StatusMasterController {
	@Autowired
	private StatusService service;

	@GetMapping("/getAllStatus")
	public List<StatusMaster> getAll() {
		return service.getAll();
	}

}
