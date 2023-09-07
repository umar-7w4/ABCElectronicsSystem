package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Admin;
import com.cg.entities.Client;
import com.cg.entities.Complaint;
import com.cg.entities.Engineer;
import com.cg.entities.Product;
import com.cg.exceptions.InValidComplaintIdException;
import com.cg.exceptions.InValidDomainException;

@Repository
public interface IComplaintRepository extends JpaRepository<Complaint,Integer>{


	
}
