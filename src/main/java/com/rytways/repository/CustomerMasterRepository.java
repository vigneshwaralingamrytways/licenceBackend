package com.rytways.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.rytways.model.CustomerMasterEntity;

@Repository
public interface CustomerMasterRepository extends JpaRepository<CustomerMasterEntity, Long> {
	boolean existsByDomesticLicenceNo(String licenseNumber);

//	boolean existsByVehicleLicenseNo(String vehicleLicenseNo);
}