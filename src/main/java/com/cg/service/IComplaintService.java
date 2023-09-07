package com.cg.service;

import java.util.List;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.entities.Product;
import com.cg.exceptions.InValidComplaintIdException;
import com.cg.exceptions.InValidDomainException;
import com.cg.exceptions.OutofWarrantyException;

public interface IComplaintService {
	
	public Complaint bookComplaint(Complaint complaint) throws Exception;
	public Complaint changeComplaint(Complaint complaint, String status) throws Exception;
	public List<Complaint> getAllClientComplaints(Client client) throws Exception;
	public List<Complaint> getAllOpenComplaints(Client client) throws Exception;
	public Engineer getEngineer(int engineerId) throws Exception;
	public Product getProductByComplaint(int complaintId) throws Exception; 

}
