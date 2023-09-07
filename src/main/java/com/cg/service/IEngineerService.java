package com.cg.service;

import java.time.LocalDate;
import java.util.List;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;



public interface IEngineerService {

	
	public List<Complaint> getAllOpenComplaints(Engineer e) throws Exception;
	public List<Complaint> getResolvedComplaints(Engineer e) throws Exception;
	public List<Complaint> getResolvedComplaintsByDate(Engineer e,LocalDate date) throws Exception;
	public List<Complaint> getComplaints(Engineer e,String status) throws Exception;
	public Complaint changeComplaintStatus(int complaintId) throws Exception; // returns updated Status;
	
	
}
