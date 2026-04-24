package com.rytways.model;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.ManyToOne;

import lombok.Data;

@Data
@Entity
public class CustomerMasterEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long customerId;

	@Column(name = "status_id")
	private Long statusId;
	@ManyToOne
	@JoinColumn(name = "status_id", insertable = false, updatable = false)
	private StatusMaster status;

	private String approvedBy;
	private String remarks;

	private String noAssi;
	private LocalDate validUntill;
	@Lob
	private String at;
	private LocalDate date;
	private String surname;
	private String otherNames;
	private String placeOfBirth;
	private LocalDate dateOfBirth;
	@Lob
	private String permanentPlaceOfResidence;
	@Column(unique = true)
	private String domesticLicenceNo;

	private LocalDate validUpto;
	private String issuingAuthority;
	private LocalDate applyDate;

//	private String fullName;//
//	private String otherName;
//	@Lob
//	private String permanentAddress;
//	@Column(unique = true)
//	private String vehicleLicenseNo;
//	private String vehicleType;
//	private LocalDate vehicleDate;
//	private String vehicleIssuingAuthority;
//	@Column(unique = true)
//	private String licenseNumber;
//	private String licenseIssuingAuthority;
//	private String placeOfIssue;
//	private LocalDate validTill;
//	private LocalDate issuedDate;
//	private LocalDate applyDate;
}
