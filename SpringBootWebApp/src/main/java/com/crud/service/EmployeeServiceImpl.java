package com.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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

	@Override
	public void saveEmployee(Employee employee) {
		repo.save(employee);
		
	}

	@Override
	public Employee getEmployeeById(long id) {
		Optional<Employee> opt = repo.findById(id);
		Employee emp=null;
		if(opt.isPresent()) {
			return emp=opt.get();
		}
		else {
			throw new RuntimeException("User with id ="+id+" is not present in record!");
		}	
		
	}

	@Override
	public void deleteEmployeeById(long id) {
		this.repo.deleteById(id);
		
	}

//	@Override
//	public Page<Employee> findPaginated(int pageNo, int pageSize) {
//		Pageable pageable = PageRequest.of(pageNo - 1, pageSize);
//		 return this.repo.findAll(pageable);
//	}

	@Override
	public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
		 Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
	            Sort.by(sortField).descending();

	        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
	        return this.repo.findAll(pageable);
	}
	
	

}
