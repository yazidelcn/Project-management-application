package com.elcnyazid.pma.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.elcnyazid.pma.entities.Project;

public interface IProjectRepository extends CrudRepository<Project, Long> {
	@Override
	List<Project> findAll();
}
