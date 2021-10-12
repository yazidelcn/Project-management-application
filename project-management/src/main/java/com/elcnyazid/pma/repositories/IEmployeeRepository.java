package com.elcnyazid.pma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.elcnyazid.pma.dto.EmployeeProject;
import com.elcnyazid.pma.entities.Employee;

public interface IEmployeeRepository extends CrudRepository<Employee, Long> {
	
	List<Employee> findAll();
	@Query(nativeQuery=true, value="SELECT e.first_name as firstName, e.last_name as lastName, COUNT(pe.employee_id) as projectCount " + 
			"FROM employee e left join projects_employees pe ON pe.employee_id = e.employee_id " + 
			"GROUP BY e.first_name, e.last_name ORDER BY 3 DESC")	
	List<EmployeeProject> employeeProjects();
}
