package com.cg.controller;



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
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/abc-admin")
public class AdminController {
	
	@Autowired
	IAdminService iAdminService;

	@PostMapping("/addEngineer")
	public void addEngineer(@RequestBody Engineer e) {
		iAdminService.addEngineer(e);
	}
	
	@PutMapping("/changeDomain/{engineerId}/{newDomain}")
	public void changeDomain(@PathVariable int engineerId,@PathVariable String newDomain)throws InValidDomainException,InvalidEngineerIdException{
		iAdminService.changeDomain(engineerId, newDomain);
	}
	
	@DeleteMapping("/removeEngineer/{engineerId}")
	public void removeEngineer(@PathVariable int engineerId)throws InvalidEngineerIdException{
		iAdminService.removeEngineer(engineerId);
	}
	
	@GetMapping("/getComplaintsByProducts/{productCategoryName}")
	public List<Complaint> getComplaintsByProducts(@PathVariable String productCategoryName) throws Exception{
		return iAdminService.getComplaintsByProducts(productCategoryName);
	}
	
	@GetMapping("/getComplaints/{status}/{productCategoryName}")
	public List<Complaint> getComplaints(@PathVariable String status, @PathVariable String productCategoryName) throws Exception{
		return iAdminService.getComplaints(status, productCategoryName);
	}
	
	@PutMapping("/replaceEngineerFromComplaint/{complaintId}")
	public Complaint replaceEngineerFromComplaint(@PathVariable int complaintId, @RequestBody Engineer engineer)throws InValidDomainException{
		return iAdminService.replaceEngineerFromComplaint(complaintId, engineer);
	}
}
