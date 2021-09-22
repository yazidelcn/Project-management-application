package com.elcnyazid.pma.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcnyazid.pma.entities.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
	
	List<Employee> findAll();

}
