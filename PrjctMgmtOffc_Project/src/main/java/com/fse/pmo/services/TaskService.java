package com.fse.pmo.services;

import java.util.List;

import com.fse.pmo.model.PmoTask;

public interface TaskService {
	public Integer saveUpadteTask(PmoTask task);
	public List<PmoTask> getAllTasks();
	public PmoTask getTaskById(Integer taskId);
	public Integer deleteTaskById(Integer taskId);

}
