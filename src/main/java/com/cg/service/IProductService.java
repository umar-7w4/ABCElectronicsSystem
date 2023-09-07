package com.cg.service;

import java.util.List;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.entities.Product;
import com.cg.exceptions.InValidModelNumberException;

public interface IProductService {
	
	public void addProduct(Product product)  throws Exception;
	public void removeProducts(String category);
	public List<Product> getProduct(String categoryName)  throws Exception;
	
	public void updateProductWarranty(String modelNumber, int years)throws InValidModelNumberException;
	
	public List<Complaint> getProductComplaints(String productCategoryName)  throws Exception;
	
	
	
}
