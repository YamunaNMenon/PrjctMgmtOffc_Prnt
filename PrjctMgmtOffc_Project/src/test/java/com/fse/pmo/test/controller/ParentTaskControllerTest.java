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

import com.fse.pmo.controller.ParentTaskController;
import com.fse.pmo.model.PmoParentTask;
import com.fse.pmo.services.ParentTaskServiceImpl;

public class ParentTaskControllerTest {
	@InjectMocks
	ParentTaskController parentTaskController;
    
    @Mock
    ParentTaskServiceImpl parntTaskServiceImpl;
    
	private MockMvc mockMvc;
    
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(parentTaskController).build();
	}
	

	@Test
	public void test_getAllProjects() throws Exception {
		Mockito.when(parntTaskServiceImpl.getAllParentTasks()).thenReturn(createMockParentTaskList());
		Assert.assertNotNull(parentTaskController.getAllParentTasks()) ;
	}
	
	@Test
	public void test_createOrUpdate() throws Exception {
		Mockito.when( parntTaskServiceImpl.saveUpadteParentTask(createMockParentTask())).thenReturn(1);
		Assert.assertNotNull(parentTaskController.createOrUpdate(createMockParentTask())) ;		
	}
	
	private List<PmoParentTask> createMockParentTaskList() {
		List<PmoParentTask> parentTaskList = new ArrayList<PmoParentTask>();
		parentTaskList.add(createMockParentTask());
		return parentTaskList;
	}
	
	private PmoParentTask createMockParentTask() {
		PmoParentTask prntTask = new PmoParentTask();
		prntTask.setParent_task_id(1);
		prntTask.setParent_task_name("Analysis");
		return prntTask;
	}
	
	@Test
	public void test_getParentTaskById() throws Exception {
		Mockito.when(parntTaskServiceImpl.getParentTaskById(1)).thenReturn(createMockParentTask());
		Assert.assertNotNull(parentTaskController.getParentTaskById("1")) ;			
	}
	
	@Test
	public void test_deleteProject() throws Exception {
		Mockito.when(parntTaskServiceImpl.deleteParentTaskById(1)).thenReturn(1);
		Assert.assertNotNull(parentTaskController.deleteParentTask("1")) ;			
	}

}
