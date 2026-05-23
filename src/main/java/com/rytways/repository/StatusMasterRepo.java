package com.rytways.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rytways.model.StatusMaster;

public interface StatusMasterRepo extends JpaRepository<StatusMaster, Long> {

	Optional<StatusMaster> findById(Long statusId);

}
