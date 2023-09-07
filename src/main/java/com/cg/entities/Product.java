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
public class Product {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int productId;
	private String modelNumber;
	private String productName;
	private String productCategoryName; // washing machine , TV,AC,SmartPhone
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate dateofPurchase;
	private int warrentyYears;
	
	@JsonDeserialize(using = LocalDateDeserializer.class)
	@JsonSerialize(using = LocalDateSerializer.class)
	@JsonFormat(shape=JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd")
	private LocalDate warrantyDate; // should be auto generated
	
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "clinet_id", referencedColumnName = "clinetId")
	private Client client_details;

	public Product() {
		super();
	}

	public Product(String modelNumber, String productName, String productCategoryName, LocalDate dateofPurchase,
			int warrentyYears, LocalDate warrantyDate, Client client) {
		super();
		this.modelNumber = modelNumber;
		this.productName = productName;
		this.productCategoryName = productCategoryName;
		this.dateofPurchase = dateofPurchase;
		this.warrentyYears = warrentyYears;
		this.warrantyDate = warrantyDate;
		this.client_details = client;
	}

	public int getProductId() {
		return productId;
	}
	
	public String getModelNumber() {
		return modelNumber;
	}

	public void setModelNumber(String modelNumber) {
		this.modelNumber = modelNumber;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getProductCategoryName() {
		return productCategoryName;
	}

	public void setProductCategoryName(String productCategoryName) {
		this.productCategoryName = productCategoryName;
	}

	public LocalDate getDateofPurchase() {
		return dateofPurchase;
	}

	public void setDateofPurchase(LocalDate dateofPurchase) {
		this.dateofPurchase = dateofPurchase;
	}

	public int getWarrentyYears() {
		return warrentyYears;
	}

	public void setWarrentyYears(int warrentyYears) {
		this.warrentyYears = warrentyYears;
	}

	public LocalDate getWarrantyDate() {
		return warrantyDate;
	}

	public void setWarrantyDate(LocalDate warrantyDate) {
		this.warrantyDate = warrantyDate;
	}

	public Client getClient() {
		return client_details;
	}

	public void setClient(Client client) {
		this.client_details = client;
	} 
	
	
	
}
