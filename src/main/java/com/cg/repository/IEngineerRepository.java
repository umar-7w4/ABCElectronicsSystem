package com.cg.repository;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Complaint;
import com.cg.entities.Engineer;


@Repository
public interface IEngineerRepository extends JpaRepository<Engineer,Integer>{

	
	
}
