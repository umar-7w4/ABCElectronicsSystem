package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.entities.Product;
import com.cg.exceptions.InValidDomainException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.repository.IComplaintRepository;
import com.cg.repository.IEngineerRepository;
import com.cg.repository.IProductRepository;

@Service("IComplaintService")
public class IComplaintServiceImpl implements IComplaintService{
	
	
	@Autowired
	IComplaintRepository iComplaintRepository;
	
	@Autowired
	IEngineerRepository iEngineerRepository;
	
	@Autowired
	IProductRepository iProductRepository;


	@Override
	public Complaint bookComplaint(Complaint complaint) throws Exception {
		iComplaintRepository.saveAndFlush(complaint);
		return null;
	}

	@Override
	public Complaint changeComplaint(Complaint complaint, String status) throws Exception {
		Complaint  bean = null;
		try {
			bean = iComplaintRepository.findById(complaint.getComplaintId()).get();
		}
		catch(Exception e) {
			throw new InValidDomainException("Complaint details not found!");
		}
		bean.setStatus(status);
		return bean;
	}

	@Override
	public List<Complaint> getAllClientComplaints(Client client) throws Exception {
		return client.getComplaints();
	}

	@Override
	public List<Complaint> getAllOpenComplaints(Client client) throws Exception {
		List<Complaint> ans = new ArrayList<Complaint>();
		try {
			for(Complaint i : client.getComplaints()) {
				if(i.getStatus().equals("Open")) {
					ans.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Complaint details not found!");
		}
		return ans;
	}

	@Override
	public Engineer getEngineer(int engineerId) throws Exception {
		Engineer  bean = null;
		try {
			bean = iEngineerRepository.findById(engineerId).get();
		}
		catch(Exception e) {
			throw new InvalidEngineerIdException("Engineer details not found!");
		}
		return bean;
	}

	@Override
	public Product getProductByComplaint(int complaintId) throws Exception {
		Complaint  bean = null;
		Product product = null;
		try {
			bean = iComplaintRepository.findById(complaintId).get();
		}
		catch(Exception e) {
			throw new InValidDomainException("Complaint details not found!");
		}
		for(Product i: iProductRepository.findAll() ) {
			if(i.getModelNumber().equals(bean.getProductModelNumber())) {
				product = i;
			}
		}
		return product;
	}

}
