package com.cg.controller;

import java.util.List;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.entities.Product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InvalidClientIdException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.service.IClientService;
import com.cg.service.IComplaintService;

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
@RequestMapping("/abc-complaint")
public class ComplaintController {

	
	@Autowired
	IComplaintService iComplaintService;
	
	@PostMapping("/bookComplaint")
	public Complaint bookComplaint(@RequestBody Complaint complaint) throws Exception{
		return iComplaintService.bookComplaint(complaint);
	}
	
	@PutMapping("/changeComplaint/{status}")
	public Complaint changeComplaint(@RequestBody Complaint complaint, @PathVariable String status) throws Exception{
		return iComplaintService.changeComplaint(complaint, status);
	}
	
	@GetMapping("/getAllClientComplaints")
	public List<Complaint> getAllClientComplaints(@RequestBody Client client) throws Exception{
		return iComplaintService.getAllClientComplaints(client);
	}
	
	@GetMapping("/getAllOpenComplaints")
	public List<Complaint> getAllOpenComplaints(@RequestBody Client client) throws Exception{
		return iComplaintService.getAllClientComplaints(client);
	}
	
	@GetMapping("/getEngineer/{engineerId}")
	public Engineer getEngineer(@PathVariable int engineerId) throws Exception{
		return iComplaintService.getEngineer(engineerId);
	}
	
	@GetMapping("/getProductByComplaint/{complaintId}")
	public Product getProductByComplaint(int complaintId) throws Exception{
		return iComplaintService.getProductByComplaint(complaintId);
	}

}
