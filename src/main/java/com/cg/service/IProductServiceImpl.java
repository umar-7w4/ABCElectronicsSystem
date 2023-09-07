package com.cg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.entities.Product;
import com.cg.exceptions.InValidModelNumberException;
import com.cg.exceptions.InvalidEngineerIdException;
import com.cg.repository.IProductRepository;

@Service("IProductService")
public class IProductServiceImpl implements IProductService{
	
	@Autowired
	IProductRepository iProductRepository;

	@Override
	public void addProduct(Product product)  throws Exception{
		iProductRepository.saveAndFlush(product);
	}

	@Override
	public void removeProducts(String category) {
		List<Product> ans = new ArrayList<Product>();
		for(Product i : iProductRepository.findAll()) {
			if(i.getProductCategoryName().equals(category)) {
				ans.add(i);
			}
		}
		for(Product i : ans) {
			iProductRepository.deleteById(i.getProductId());
		}
	}

	@Override
	public List<Product> getProduct(String categoryName)  throws Exception{
		List<Product> ans = new ArrayList<Product>();
		try {
			for(Product i : iProductRepository.findAll()) {
				if(i.getProductCategoryName().equals(categoryName)) {
					ans.add(i);
				}
			}
		}
		catch(Exception es) {
			throw new Exception("Product details not found!");
		}
		return ans;
	}

	@Override
	public void updateProductWarranty(String modelNumber, int years) throws InValidModelNumberException {
		Product bean = null;
		try {
			for(Product i : iProductRepository.findAll()) {
				if(i.getModelNumber().equals(modelNumber)) {
					bean = i;
				}
			}
		}
		catch(Exception es) {
			throw new InValidModelNumberException("Product details not found!");
		}
		bean.setWarrentyYears(years);
		
	}

	@Override
	public List<Complaint> getProductComplaints(String productCategoryName) throws Exception {
		Product bean = null;
		try {
			for(Product i : iProductRepository.findAll()) {
				if(i.getProductCategoryName().equals(productCategoryName)) {
					bean = i;
				}
			}
		}
		catch(Exception es) {
			throw new InValidModelNumberException("Product details not found!");
		}
		return bean.getClient().getComplaints();
	}


}
