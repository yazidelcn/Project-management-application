package com.elcnyazid.pma.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.Sql.ExecutionPhase;
import org.springframework.test.context.jdbc.SqlGroup;

import com.elcnyazid.pma.entities.Project;
import com.elcnyazid.pma.repositories.IProjectRepository;

@SpringBootTest
@SqlGroup({
	@Sql(executionPhase = ExecutionPhase.BEFORE_TEST_METHOD, scripts = {"classpath:schema.sql", "classpath:data.sql"}),
	@Sql(executionPhase = ExecutionPhase.AFTER_TEST_METHOD, scripts = "classpath:drop.sql")
})
public class ProjectRepositoryIntegrationTest {
	@Autowired
	IProjectRepository projectRepo;
	
	@Test
	public void ifNewProjectSaved_thenSuccess() {
		
		Project p = new Project("new project", "COMPLETE","Dummy Desc");
		Project p1 = new Project("new project1", "COMPLETE","Dummy Desc");
		projectRepo.save(p);
		projectRepo.save(p1);
		
		assertEquals(6, projectRepo.findAll().size());
	}
}
