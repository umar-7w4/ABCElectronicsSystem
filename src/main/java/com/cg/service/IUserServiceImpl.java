package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InvalidClientIdException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.repository.IClientRepository;
import com.cg.repository.IComplaintRepository;
import com.cg.repository.IEngineerRepository;

@Service("IUserService")
public class IUserServiceImpl implements IUserService{
	
	
	@Autowired
	IClientRepository iClientRepository;
	
	@Autowired
	IEngineerRepository iEngineerRepository;
	
	@Autowired
	IComplaintRepository iComplaintRepository;

	@Override
	public void saveClient(Client c) throws Exception {
		iClientRepository.saveAndFlush(c);
	}

	@Override
	public Client getClientByCLientId(int clientId) throws InvalidClientIdException {
		Client  bean = null;
		try {
			bean = iClientRepository.findById(clientId).get();
		}
		catch(Exception e) {
			throw new InvalidClientIdException("Client details not found!");
		}
		return bean;
	}

	@Override
	public void saveEngineer(Engineer e) throws Exception {
		iEngineerRepository.saveAndFlush(e);
		
	}

	@Override
	public Engineer getEngineerById(int id) throws InvalidEngineerIdException {
		Engineer  bean = null;
		try {
			bean = iEngineerRepository.findById(id).get();
		}
		catch(Exception e) {
			throw new InvalidEngineerIdException("Engineer details not found!");
		}
		return bean;
	}

	@Override
	public List<Engineer> getEngineersByDomain(String category) throws Exception {
		List<Engineer> ans = new ArrayList<>();
		try {
			for(Engineer i : iEngineerRepository.findAll()) {
				if(i.getDomain().equals(category)) {
					ans.add(i);
				}
			}
		}
		catch(Exception e) {
			throw new InvalidEngineerIdException("Engineer details not found!");
		}
		return ans;
	}

	@Override
	public Complaint chnageStatusOfComplaint(int complaintId) throws Exception {
		Complaint bean = null;
		try {
			bean = iComplaintRepository.findById(complaintId).get();
		}
		catch(Exception e) {
			throw new Exception("Complaint details not found!");
		}
		bean.setStatus("Changed");
		return bean;
	}
	@Override
	public Client signIn(Client client) throws Exception {
		iClientRepository.saveAndFlush(client);
		return client;
	}

	@Override
	public Client signOut(Client client) throws Exception {
		Client  bean = null;
		try {
			bean = iClientRepository.findById(client.getClinetId()).get();
		}
		catch(Exception e) {
			throw new InvalidClientIdException("Client details not found!");
		}
		iClientRepository.deleteById(client.getClinetId());
		return bean;
	}
	
	

}
