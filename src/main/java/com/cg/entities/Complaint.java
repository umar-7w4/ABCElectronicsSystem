package com.cg.entities;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.datatype.jsr310.deser.LocalDateDeserializer;
import com.fasterxml.jackson.datatype.jsr310.ser.LocalDateSerializer;

@Entity
public class Complaint {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int complaintId;
	private String productModelNumber; // complaint product model number, Model Number from Product Class
	private String complaintName;
	private String status; // open , resolve online , resolve after home visit , resolved , closed
	// note : engineer cannot open or close the complaint
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate complaintDate;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "employee_id", referencedColumnName = "employeeId")
	private Engineer engineer;
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clinet_d", referencedColumnName = "clinetId")
	private Client client_details;

	public Complaint() {
		super();
	}

	

	public Complaint(int complaintId, String productModelNumber, String complaintName, String status,
			LocalDate complaintDate, Engineer engineer, Client client_details) {
		super();
		this.complaintId = complaintId;
		this.productModelNumber = productModelNumber;
		this.complaintName = complaintName;
		this.status = status;
		this.complaintDate = complaintDate;
		this.engineer = engineer;
		this.client_details = client_details;
	}



	public int getComplaintId() {
		return complaintId;
	}

	public void setComplaintId(int complaintId) {
		this.complaintId = complaintId;
	}

	public String getProductModelNumber() {
		return productModelNumber;
	}

	public void setProductModelNumber(String productModelNumber) {
		this.productModelNumber = productModelNumber;
	}

	public String getComplaintName() {
		return complaintName;
	}

	public void setComplaintName(String complaintName) {
		this.complaintName = complaintName;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Engineer getEngineer() {
		return engineer;
	}

	public void setEngineer(Engineer engineer) {
		this.engineer = engineer;
	}

	public Client getClient_details() {
		return client_details;
	}

	public void setClient_details(Client client_details) {
		this.client_details = client_details;
	}



	public LocalDate getComplaintDate() {
		return complaintDate;
	}



	public void setComplaintDate(LocalDate complaintDate) {
		this.complaintDate = complaintDate;
	}

	
	


}
