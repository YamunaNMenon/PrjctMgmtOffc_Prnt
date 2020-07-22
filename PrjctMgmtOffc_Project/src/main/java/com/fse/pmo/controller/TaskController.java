package com.fse.pmo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fse.pmo.model.PmoTask;
import com.fse.pmo.services.TaskServiceImpl;

@RestController
@CrossOrigin(origins = "*")
public class TaskController {
	@Autowired
	private TaskServiceImpl taskService;
	
	@PostMapping("/task/saveUpdateTask")
	public Integer createOrUpdate(@RequestBody PmoTask task) {
		return taskService.saveUpadteTask(task);
	}
	
	@GetMapping("/task/getAllTasks")
	public List<PmoTask> getAllTasks(){
		return taskService.getAllTasks();
	}
	
	@GetMapping("/task/getTask/{id}")
	public PmoTask getTaskById(@PathVariable String taskId) {
		return taskService.getTaskById(Integer.parseInt(taskId));
	}
	
	@DeleteMapping("/task/delete/{id}")
	public Integer deleteTask(@PathVariable String id) {
		return taskService.deleteTaskById(Integer.parseInt(id));
	}

}
