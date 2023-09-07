package com.cg.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity
@Table(name="client_details")
public class Client {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int clinetId; // unique String name like mike123
	private String password;
	
	@OneToMany(mappedBy = "client_details" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Product> productOwned;
	
	@OneToMany(mappedBy = "client_details" , fetch = FetchType.EAGER)
	@Fetch(value = FetchMode.SUBSELECT)
	private List<Complaint> complaints;
	
	private String address;
	private long phoneNumber;

	public Client() {
		super();
	}

	public Client(int clinetId, String password, List<Product> productOwned, List<Complaint> complaints, String address,
			long phoneNumber) {
		super();
		this.clinetId = clinetId;
		this.password = password;
		this.productOwned = productOwned;
		this.complaints = complaints;
		this.address = address;
		this.phoneNumber = phoneNumber;
	}


	public int getClinetId() {
		return clinetId;
	}


	public void setClinetId(int clinetId) {
		this.clinetId = clinetId;
	}


	public String getPassword() {
		return password;
	}


	public void setPassword(String password) {
		this.password = password;
	}


	public List<Product> getProductOwned() {
		return productOwned;
	}


	public void setProductOwned(List<Product> productOwned) {
		this.productOwned = productOwned;
	}


	public List<Complaint> getComplaints() {
		return complaints;
	}


	public void setComplaints(List<Complaint> complaints) {
		this.complaints = complaints;
	}


	public String getAddress() {
		return address;
	}


	public void setAddress(String address) {
		this.address = address;
	}


	public long getPhoneNumber() {
		return phoneNumber;
	}


	public void setPhoneNumber(long phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	
	
	

}
