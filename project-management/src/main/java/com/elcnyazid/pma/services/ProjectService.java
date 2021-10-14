package com.elcnyazid.pma.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.elcnyazid.pma.dto.ChartData;
import com.elcnyazid.pma.entities.Project;
import com.elcnyazid.pma.repositories.IProjectRepository;

@Service
public class ProjectService {

	@Autowired
	private IProjectRepository projectRepo;

	public Project save(Project project) {
		return projectRepo.save(project);
	}

	public List<Project> getAll() {
		return projectRepo.findAll();
	}
	
	public List<ChartData> getProjectStatus(){
		return projectRepo.chartData();
	}
	
	
}
