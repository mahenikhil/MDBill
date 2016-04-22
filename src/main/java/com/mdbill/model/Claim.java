package com.mdbill.model;

import java.util.Date;

import org.hibernate.validator.constraints.NotBlank;
import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.mdbill.serializer.JSONDateDeSerializer;
import com.mdbill.serializer.JSONDateSerializer;


public class Claim {
	
	@Id
	private String id;
	
	@NotBlank(message="Name of patient cannot be left blank")
	private String patientName;
	
	//@NotEmpty(message="Amount cannot be left blank")
	private String insurer;
	@NotBlank(message="Name of hospital cannot be left blank")
	private String hospital;
	private String billCode;
	@JsonSerialize(using=JSONDateSerializer.class)
	@JsonDeserialize(using=JSONDateDeSerializer.class)
	private Date visitDate;
	
	@NotBlank(message="Service Location cannot be left blank")
	private String serviceLocation;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public String getInsurer() {
		return insurer;
	}

	public void setInsurer(String insurer) {
		this.insurer = insurer;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getBillCode() {
		return billCode;
	}

	public void setBillCode(String billCode) {
		this.billCode = billCode;
	}

	public Date getVisitDate() {
		return visitDate;
	}

	public void setVisitDate(Date visitDate) {
		this.visitDate = visitDate;
	}

	public String getServiceLocation() {
		return serviceLocation;
	}

	public void setServiceLocation(String serviceLocation) {
		this.serviceLocation = serviceLocation;
	}
	

}
