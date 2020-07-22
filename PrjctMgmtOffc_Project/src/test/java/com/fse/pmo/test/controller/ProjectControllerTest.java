package com.fse.pmo.test.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fse.pmo.controller.ProjectController;
import com.fse.pmo.model.PmoProject;
import com.fse.pmo.services.ProjectServiceImpl;

public class ProjectControllerTest {
	@InjectMocks
	ProjectController projectController;
    
    @Mock
    ProjectServiceImpl projectService;
    
	private MockMvc mockMvc;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(projectController).build();
	}
	
	@Test
	public void test_getAllProjects() throws Exception {
		Mockito.when(projectService.getAllProjects()).thenReturn(createMockProjectList());
		Assert.assertNotNull(projectController.getAllProjects()) ;
	}
	
	@Test
	public void test_createOrUpdate() throws Exception {
		Mockito.when(projectService.saveUpadteProject(createMockProject())).thenReturn(1);
		Assert.assertNotNull(projectController.createOrUpdate(createMockProject())) ;		
	}
	
	private List<PmoProject> createMockProjectList() {
		List<PmoProject> projectList = new ArrayList<PmoProject>();
		projectList.add(createMockProject());
		return projectList;
	}
	
	private PmoProject createMockProject() {
		PmoProject project = new PmoProject();
		project.setProject_id(1);
		project.setProject("Test Project");
		project.setPriority(27);
		project.setStartDate(new Date());
		project.setEndDate(new Date());
//		User user = new User() ;
//		user.setId(1);
//		user.setFirstName("John");
//		user.setLastName("Harry");
//		user.setEmployeeId("1234");
//		project.setUser(user);
		
		return project;
	}
	
	@Test
	public void test_getProjectById() throws Exception {
		Mockito.when(projectService.getProjectById(1)).thenReturn(createMockProject());
		Assert.assertNotNull(projectController.getProjectById("1")) ;			
	}
	
	@Test
	public void test_deleteProject() throws Exception {
		Mockito.when(projectService.deleteProjectById((1))).thenReturn(1);
		Assert.assertNotNull(projectController.deleteProject("1")) ;			
	}
}
