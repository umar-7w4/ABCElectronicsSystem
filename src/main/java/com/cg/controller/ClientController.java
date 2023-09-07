package com.cg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InvalidClientIdException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.service.IClientService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InValidDomainException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.service.IAdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/abc-client")
public class ClientController {
	
	@Autowired 
	IClientService iClientService;
	
	@PostMapping("saveClient")
	public void saveClient(@RequestBody Client c) {
		iClientService.saveClient(c);
	}
	
	@GetMapping("/getClientByCLientId/{clientId}")
	public Client getClientByCLientId(@PathVariable int clientId)throws InvalidClientIdException{
		return iClientService.getClientByCLientId(clientId);
	}
	
	@GetMapping("/getEngineerById/{id}")
	public Engineer getEngineerById(@PathVariable int id) throws InvalidEngineerIdException{
		return iClientService.getEngineerById(id);
	}
	
	@GetMapping("/getEngineersByDomain/{category}")
	public List<Engineer> getEngineersByDomain(@PathVariable String category) throws InvalidEngineerIdException{
		return iClientService.getEngineersByDomain(category);
	}
	
	@PutMapping("/chnageStatusOfComplaint/{complaintId}")
	public Complaint chnageStatusOfComplaint(@PathVariable int complaintId) throws Exception{
		return iClientService.chnageStatusOfComplaint(complaintId);
	}
	
	@PostMapping("/signIn")
	public Client signIn(@RequestBody Client client) throws Exception{
		return iClientService.signIn(client);
	}
	
	@DeleteMapping("/signOut")
	public Client signOut(@RequestBody Client client) throws Exception{
		return iClientService.signOut(client);
	}

}
