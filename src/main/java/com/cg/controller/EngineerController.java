package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InvalidClientIdException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.service.IClientService;
import com.cg.service.IComplaintService;
import com.cg.service.IEngineerService;

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
@RequestMapping("/abc-engineer")
public class EngineerController {
	
	@Autowired
	IEngineerService iEngineerService;
	
	@GetMapping("/getAllOpenComplaints")
	public List<Complaint> getAllOpenComplaints(@RequestBody Engineer e) throws Exception{
		return iEngineerService.getAllOpenComplaints(e);
	}
	
	@GetMapping("/getResolvedComplaints")
	public List<Complaint> getResolvedComplaints(@RequestBody Engineer e) throws Exception{
		return iEngineerService.getResolvedComplaints(e);
	}
	
	@GetMapping("/getResolvedComplaintsByDate")
	public List<Complaint> getResolvedComplaintsByDate(@RequestBody Engineer e, @RequestParam("localDate") @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate date) throws Exception{
		return iEngineerService.getResolvedComplaintsByDate(e, date);
	}
	
	@GetMapping("/getComplaints/{status}")
	public List<Complaint> getComplaints(@RequestBody Engineer e, @PathVariable String status) throws Exception{
		return iEngineerService.getComplaints(e, status);
	}
	
	@PutMapping("/changeComplaintStatus/{complaintId}")
	public Complaint changeComplaintStatus(@PathVariable int complaintId) throws Exception{
		return iEngineerService.changeComplaintStatus(complaintId);
	}

}
