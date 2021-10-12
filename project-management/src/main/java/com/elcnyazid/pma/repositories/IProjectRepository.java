package com.elcnyazid.pma.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.elcnyazid.pma.dto.ChartData;
import com.elcnyazid.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {
	@Override
	List<Project> findAll();
	
	@Query(nativeQuery = true, value= "SELECT STAGE, count(STAGE) as COUNT FROM PROJECT GROUP BY STAGE")
	List<ChartData>  chartData();
}
