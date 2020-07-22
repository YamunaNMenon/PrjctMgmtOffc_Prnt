package com.fse.pmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pmo.model.PmoParentTask;
import com.fse.pmo.services.ParentTaskServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class ParentTaskController {

	@Autowired
	private ParentTaskServiceImpl parentTaskService;
	
	@PostMapping("/parentTask/saveUpdateParentTask")
	public Integer createOrUpdate(@RequestBody PmoParentTask parentTask) {
		return parentTaskService.saveUpadteParentTask(parentTask);
	}
	
	@GetMapping("/parentTask/getAllParentTasks")
	public List<PmoParentTask> getAllParentTasks(){
		return parentTaskService.getAllParentTasks();
	}
	
	@GetMapping("/parentTask/getParentTask/{parent_task_id}")
//	@RequestMapping(value = "/parentTask/getParentTask/{parent_task_id}", method = RequestMethod.GET)
	public PmoParentTask getParentTaskById(@PathVariable String  parent_task_id) {
		return parentTaskService.getParentTaskById(Integer.parseInt(parent_task_id));
	}
	
	@DeleteMapping("/parentTask/delete/{parent_task_id}")
	public Integer deleteParentTask(@PathVariable String parent_task_id) {
		return parentTaskService.deleteParentTaskById(Integer.parseInt(parent_task_id));
	}
}
