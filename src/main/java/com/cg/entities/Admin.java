package com.cg.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/*
 
{
	"password" : "Vishal@123",
	"contactNumber" : 8898778567,
	"emailId" : "Vishal@gmail.com"
}
  
 */


@Entity
public class Admin {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int adminId; 
	private String password;
	private long contactNumber;
	private String emailId;
	
	public Admin() {
		super();
	}
	
	public Admin(int adminId, String password, long contactNumber, String emailId) {
		super();
		this.adminId = adminId;
		this.password = password;
		this.contactNumber = contactNumber;
		this.emailId = emailId;
	}

	public int getAdminId() {
		return adminId;
	}

	public void setAdminId(int adminId) {
		this.adminId = adminId;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getContactNumber() {
		return contactNumber;
	}

	public void setContactNumber(long contactNumber) {
		this.contactNumber = contactNumber;
	}

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}
	
	
	
	
}
