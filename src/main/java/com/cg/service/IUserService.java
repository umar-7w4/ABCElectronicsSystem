package com.cg.service;

import java.util.List;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InvalidClientIdException;
import com.cg.exceptions.InvalidEngineerIdException;

public interface IUserService {

	public void saveClient(Client c) throws Exception;
	public Client getClientByCLientId(int clientId)throws InvalidClientIdException ;
	
	public void saveEngineer(Engineer e) throws Exception;
	public Engineer getEngineerById(int id) throws InvalidEngineerIdException;
	public List<Engineer> getEngineersByDomain(String category) throws Exception;
	public Complaint chnageStatusOfComplaint(int complaintId) throws Exception; // returns updated Status , can close the complaint if problem resolve
	
	public Client signIn(Client client) throws Exception;
	public Client signOut(Client client) throws Exception;

}
