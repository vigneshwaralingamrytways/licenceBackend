package com.rytways.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rytways.Repository.StatusMasterRepo;
import com.rytways.model.StatusMaster;

@Service

public class StatusService {

	@Autowired
	StatusMasterRepo repo;

	public List<StatusMaster> getAll() {
		return repo.findAll();
	}
}
