package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.entities.Product;
import com.cg.exceptions.InValidDomainException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.repository.IAdminRepository;
import com.cg.repository.IComplaintRepository;
import com.cg.repository.IEngineerRepository;
import com.cg.repository.IProductRepository;

@Service("IAdminService")
public class IAdminServiceImpl implements IAdminService{
	
	@Autowired
	IAdminRepository iAdminRepository;
	
	@Autowired
	IEngineerRepository iEngineerRepository;
	
	@Autowired
	IProductRepository iProductRepository;
	
	@Autowired
	IComplaintRepository iComplaintRepository;

	@Override
	public void addEngineer(Engineer e) {
		iEngineerRepository.saveAndFlush(e);
	}

	@Override
	public void changeDomain(int engineerId, String newDomain)
			throws InValidDomainException, InvalidEngineerIdException {
		try {
			for(Engineer i : iEngineerRepository.findAll()) {
				if(i.getEmployeeId()==engineerId) {
					i.setDomain(newDomain);
				}
			}
		}
		catch(Exception e) {
			throw new InvalidEngineerIdException("Engineer details not found!");
		}
		
	}

	@Override
	public void removeEngineer(int engineerId) throws InvalidEngineerIdException {
		Engineer  bean = null;
		try {
			bean = iEngineerRepository.findById(engineerId).get();
		}
		catch(Exception e) {
			throw new InvalidEngineerIdException("Engineer details not found!");
		}
		iEngineerRepository.deleteById(engineerId);
		
	}

	@Override
	public List<Complaint> getComplaintsByProducts(String productCategoryName) throws Exception {
		List<Complaint> ans = new ArrayList<>();
		try {
			for(Product i : iProductRepository.findAll()) {
				if(i.getProductCategoryName().equals(productCategoryName)) {
					ans = i.getClient().getComplaints();
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Product details not found!");
		}
		return ans;
	}

	@Override
	public List<Complaint> getComplaints(String status, String productCategoryName)  throws Exception {
		List<Complaint> ans = new ArrayList<>();
		List<Complaint> temp = new ArrayList<>();
		try {
			for(Product i : iProductRepository.findAll()) {
				if(i.getProductCategoryName().equals(productCategoryName) ) {
					temp = i.getClient().getComplaints();
				}
			}
		}
		catch(Exception e) {
			throw new Exception("Product details not found!");
		}
		for(Complaint i : temp) {
			if(i.getStatus().equals(status)) {
				ans.add(i);
			}
		}
		return ans;
	}

	@Override
	public Complaint replaceEngineerFromComplaint(int complaintId, Engineer engineer) throws InValidDomainException {
		Complaint  bean = null;
		try {
			bean = iComplaintRepository.findById(complaintId).get();
		}
		catch(Exception e) {
			throw new InValidDomainException("Complaint details not found!");
		}
		bean.setEngineer(engineer);
		return bean;
	}

}
