package com.cg.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
public class Engineer {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int employeeId; // treat like login id
	private String password;
	private String engineerName;
	private String domain; // like washing machine , AC, Mobile phone
	
	@OneToMany(mappedBy = "engineer" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Complaint> complaints;

	public Engineer() {
		super();
	}

	public Engineer(int employeeId, String password, String engineerName, String domain, List<Complaint> complaints) {
		super();
		this.employeeId = employeeId;
		this.password = password;
		this.engineerName = engineerName;
		this.domain = domain;
		this.complaints = complaints;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getEngineerName() {
		return engineerName;
	}

	public void setEngineerName(String engineerName) {
		this.engineerName = engineerName;
	}

	public String getDomain() {
		return domain;
	}

	public void setDomain(String domain) {
		this.domain = domain;
	}

	public List<Complaint> getComplaints() {
		return complaints;
	}

	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}
	
	
	
	
}
