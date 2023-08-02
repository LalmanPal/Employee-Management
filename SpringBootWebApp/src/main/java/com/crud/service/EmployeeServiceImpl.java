package com.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Employee;
import com.crud.repo.EmployeeRepo;
@Service
public class EmployeeServiceImpl implements EmployeeService {
	
	@Autowired
	private EmployeeRepo repo;

	@Override
	public List<Employee> getAllEmployees() {
		
		return repo.findAll();
	}

}
