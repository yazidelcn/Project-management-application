package com.elcnyazid.pma.entities;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Project {
	@Id @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long projectId;
	private String name;
	private String stage;
	private String description;
	
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "PROJECTS_EMPLOYEES", joinColumns = @JoinColumn(name = "PROJECT_ID"), inverseJoinColumns = @JoinColumn(name = "EMPLOYEE_ID"))
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


	public List<Employee> getEmployees() {
		return employees;
	}


	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}


	@Override
	public String toString() {
		return "Project [projectId=" + projectId + ", name=" + name + ", stage=" + stage + ", description="
				+ description + ", employees=" + employees + "]";
	}


	
	
	
	
}
