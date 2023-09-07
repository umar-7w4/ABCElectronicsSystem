package com.cg.controller;

import java.time.LocalDate;
import java.util.List;

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
import com.cg.service.IEngineerService;
import com.cg.service.IProductService;

import io.swagger.v3.oas.annotations.parameters.RequestBody;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.exceptions.InValidDomainException;
import com.cg.exceptions.InValidModelNumberException;
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
@RequestMapping("/abc-product")
public class ProductController {
	
	@Autowired 
	IProductService iProductService;
	
	@PostMapping("/addProduct")
	public void addProduct(@RequestBody Product product)  throws Exception{
		iProductService.addProduct(product);
	}
	
	@DeleteMapping("/removeProducts/{category}")
	public void removeProducts(@PathVariable String category) {
		iProductService.removeProducts(category);
	}
	
	@GetMapping("/getProduct/{categoryName}")
	public List<Product> getProduct(@PathVariable String categoryName)  throws Exception{
		return iProductService.getProduct(categoryName);
	}
	
	@GetMapping("/updateProductWarranty/{modelNumber}/{years}")
	public void updateProductWarranty(@PathVariable String modelNumber, @PathVariable int years)throws InValidModelNumberException{
		iProductService.updateProductWarranty(modelNumber, years);
	}
	
	@GetMapping("/getProductComplaints/{productCategoryName}")
	public List<Complaint> getProductComplaints(@PathVariable String productCategoryName)  throws Exception{
		return iProductService.getProductComplaints(productCategoryName);
	}

}
