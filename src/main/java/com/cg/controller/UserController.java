package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InvalidClientIdException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.service.IClientService;
import com.cg.service.IUserService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

@RestController
@RequestMapping("/abc-user")
public class UserController {

	@Autowired 
	IUserService iUserService;
	
	@PostMapping("saveClient")
	public void saveClient(@RequestBody Client c) throws Exception {
		iUserService.saveClient(c);
	}
	
	@GetMapping("/getClientByCLientId/{clientId}")
	public Client getClientByCLientId(@PathVariable int clientId)throws InvalidClientIdException{
		return iUserService.getClientByCLientId(clientId);
	}
	
	@GetMapping("/getEngineerById/{id}")
	public Engineer getEngineerById(@PathVariable int id) throws InvalidEngineerIdException{
		return iUserService.getEngineerById(id);
	}
	
	@GetMapping("/getEngineersByDomain/{category}")
	public List<Engineer> getEngineersByDomain(@PathVariable String category) throws Exception{
		return iUserService.getEngineersByDomain(category);
	}
	
	@PutMapping("/chnageStatusOfComplaint/{complaintId}")
	public Complaint chnageStatusOfComplaint(@PathVariable int complaintId) throws Exception{
		return iUserService.chnageStatusOfComplaint(complaintId);
	}
	
	@PostMapping("/signIn")
	public Client signIn(@RequestBody Client client) throws Exception{
		return iUserService.signIn(client);
	}
	
	@DeleteMapping("/signOut")
	public Client signOut(@RequestBody Client client) throws Exception{
		return iUserService.signOut(client);
	}
}
