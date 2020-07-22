package com.fse.pmo.services;

import java.util.List;

import com.fse.pmo.model.PmoParentTask;

public interface ParentTaskService {
	public Integer saveUpadteParentTask(PmoParentTask parentTask);
	public List<PmoParentTask> getAllParentTasks();
	public PmoParentTask getParentTaskById(Integer parentTaskId);
	public Integer deleteParentTaskById(Integer parentTaskId);

}
