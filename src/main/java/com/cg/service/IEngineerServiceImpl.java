package com.cg.service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InValidDomainException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.repository.IComplaintRepository;
import com.cg.repository.IEngineerRepository;

@Service("IEngineerService")
public class IEngineerServiceImpl implements IEngineerService{
	
	@Autowired
	IEngineerRepository iEngineerRepository;
	
	@Autowired
	IComplaintRepository iComplaintRepository;

	@Override
	public List<Complaint> getAllOpenComplaints(Engineer e) throws Exception{
		Engineer  bean = null;
		try {
			bean = iEngineerRepository.findById(e.getEmployeeId()).get();
		}
		catch(Exception es) {
			throw new InvalidEngineerIdException("Complaint details not found!");
		}
		return bean.getComplaints();
	}

	@Override
	public List<Complaint> getResolvedComplaints(Engineer e) throws Exception{
		List<Complaint> ans = new ArrayList<Complaint>();
		try {
			for(Complaint i : iComplaintRepository.findAll()) {
				if(i.getStatus().equals("Resolved")) {
					ans.add(i);
				}
			}
		}
		catch(Exception es) {
			throw new InvalidEngineerIdException("Complaint details not found!");
		}
		return ans;
	}

	@Override
	public List<Complaint> getResolvedComplaintsByDate(Engineer e, LocalDate date)throws Exception {
		List<Complaint> ans = new ArrayList<Complaint>();
		try {
			for(Complaint i : iComplaintRepository.findAll()) {
				if(i.getStatus().equals("Resolved") && i.getComplaintDate().isBefore(date)) {
					ans.add(i);
				}
			}
		}
		catch(Exception es) {
			throw new InvalidEngineerIdException("Complaint details not found!");
		}
		return ans;
	}

	@Override
	public List<Complaint> getComplaints(Engineer e, String status)throws Exception {
		List<Complaint> ans = new ArrayList<Complaint>();
		try {
			for(Complaint i : iComplaintRepository.findAll()) {
				if(i.getStatus().equals(status) ) {
					ans.add(i);
				}
			}
		}
		catch(Exception es) {
			throw new InvalidEngineerIdException("Complaint details not found!");
		}
		return ans;
	}
	

	@Override
	public Complaint changeComplaintStatus(int complaintId)throws Exception {
		Complaint  bean = null;
		try {
			bean = iComplaintRepository.findById(complaintId).get();
		}
		catch(Exception e) {
			throw new InValidDomainException("Complaint details not found!");
		}
		bean.setStatus("Changed");
		return bean;
	}
	
	

}
