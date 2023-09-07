package com.cg.service;

import java.util.List;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InValidDomainException;
import com.cg.exceptions.InvalidEngineerIdException;

public interface IAdminService {
	
	public void addEngineer(Engineer e);
	public void changeDomain(int engineerId,String newDomain)throws InValidDomainException,InvalidEngineerIdException;
	public void removeEngineer(int engineerId)throws InvalidEngineerIdException;
	
	public List<Complaint> getComplaintsByProducts(String productCategoryName) throws Exception;
	public List<Complaint> getComplaints(String status,String productCategoryName) throws Exception;
	
	public Complaint replaceEngineerFromComplaint(int complaintId, Engineer engineer)throws InValidDomainException; // replace engineer from the complaint and allocate new engineer
	
	
}
