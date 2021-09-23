package com.elcnyazid.pma.entities;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Project {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	private String name;
	private String stage;
	private String description;
	
	@OneToMany(mappedBy = "project")
	private List<Employee> employees; 
	
	
	public Project() {
		 
	}


	public Project(String name, String stage, String description) {
		super(); 
		this.name = name;
		this.stage = stage;
		this.description = description;
	}


	public Long getProjectId() {
		return projectId;
	}


	public void setProjectId(Long projectId) {
		this.projectId = projectId;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getStage() {
		return stage;
	}


	public void setStage(String stage) {
		this.stage = stage;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", stage=" + stage + ", description="
				+ description + "]";
	}
	
	
	
}
