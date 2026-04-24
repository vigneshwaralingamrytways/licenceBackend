package com.rytways.service;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rytways.Repository.StatusMasterRepo;
import com.rytways.model.CustomerMasterEntity;
import com.rytways.model.StatusMaster;
import com.rytways.repository.CustomerMasterRepository;

@Service
public class CustomerMasterService {

	@Autowired
	private CustomerMasterRepository repository;
	@Autowired
	StatusMasterRepo statusRepo;

	public CustomerMasterEntity createCustomer(CustomerMasterEntity customer) {
		if (repository.existsByDomesticLicenceNo(customer.getDomesticLicenceNo())) {
			 
			throw new RuntimeException(
					"License Number '" + customer.getDomesticLicenceNo() + "' already exists in our records.");
		} 

		customer.setStatusId(1L); 
		customer.setApplyDate(LocalDate.now());

		return repository.save(customer);
	}

	public List<CustomerMasterEntity> getAllCustomers() {
		return repository.findAll();
	}

	public CustomerMasterEntity getCustomerById(Long id) {
		return repository.findById(id).orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
	}

	public void deleteCustomer(Long id) {

		if (!repository.existsById(id)) {
			throw new RuntimeException("Customer not found with id: " + id);
		}

		repository.deleteById(id);
	}

	public CustomerMasterEntity approve(Long custpmerId, CustomerMasterEntity approveCust) {
		Optional<CustomerMasterEntity> cust = repository.findById(custpmerId);
		cust.get().setApprovedBy(approveCust.getApprovedBy());
		cust.get().setRemarks(approveCust.getRemarks());
		cust.get().setStatusId(approveCust.getStatusId());
		return repository.save(cust.get());
	}

	public CustomerMasterEntity updateCustomer(Long id, CustomerMasterEntity updatedCustomer) {

		CustomerMasterEntity existingCustomer = repository.findById(id)
				.orElseThrow(() -> new RuntimeException("Customer not found with id: " + id));
		existingCustomer.setSurname(updatedCustomer.getSurname());
		existingCustomer.setOtherNames(updatedCustomer.getOtherNames());
		existingCustomer.setDateOfBirth(updatedCustomer.getDateOfBirth());
		existingCustomer.setPlaceOfBirth(updatedCustomer.getPlaceOfBirth());
		existingCustomer.setPermanentPlaceOfResidence(updatedCustomer.getPermanentPlaceOfResidence());
		existingCustomer.setDomesticLicenceNo(updatedCustomer.getDomesticLicenceNo());
		existingCustomer.setIssuingAuthority(updatedCustomer.getIssuingAuthority());
		existingCustomer.setValidUpto(updatedCustomer.getValidUpto());

		if (updatedCustomer.getStatus() != null) {
			existingCustomer.setStatusId(updatedCustomer.getStatus().getStatusId());
		} else if (updatedCustomer.getStatusId() != null) {
			existingCustomer.setStatusId(updatedCustomer.getStatusId());
		}
		existingCustomer.setApprovedBy(updatedCustomer.getApprovedBy());
		existingCustomer.setRemarks(updatedCustomer.getRemarks());

		return repository.save(existingCustomer);
	}

}
