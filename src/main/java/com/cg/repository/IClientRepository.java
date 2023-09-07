package com.cg.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cg.entities.Admin;
import com.cg.entities.Client;
import com.cg.entities.Engineer;
import com.cg.exceptions.InvalidClientIdException;
import com.cg.exceptions.InvalidEngineerIdException;

@Repository
public interface IClientRepository extends JpaRepository<Client,Integer>{


}
