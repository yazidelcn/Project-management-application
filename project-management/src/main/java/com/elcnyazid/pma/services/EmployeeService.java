package com.elcnyazid.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcnyazid.pma.dto.EmployeeProject;
import com.elcnyazid.pma.entities.Employee;
import com.elcnyazid.pma.repositories.IEmployeeRepository;
@Service
public class EmployeeService {

	@Autowired
	private IEmployeeRepository employeeRepo;

	public Employee save(Employee emp) {
		return employeeRepo.save(emp);
	}
	
	public List<Employee> getAll(){
		return employeeRepo.findAll();
	}
	
	public List<EmployeeProject> employeeProjects(){
		return employeeRepo.employeeProjects();
	}
	
	
	
}
