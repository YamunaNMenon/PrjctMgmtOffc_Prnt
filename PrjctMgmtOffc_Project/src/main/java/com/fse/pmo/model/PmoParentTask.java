package com.fse.pmo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="pmo_parent_task")
@JsonIgnoreProperties(value = { "pmoTask"}, allowSetters = true)
public class PmoParentTask {

	@Id
	@Column(name="parent_task_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer parent_task_id;
	
	@Column(name="parent_task_name")
	private String parent_task_name;
	
	@OneToMany(mappedBy="parentTask",  cascade = CascadeType.ALL)
	private List<PmoTask> pmoTask;

	public Integer getParent_task_id() {
		return parent_task_id;
	}

	public void setParent_task_id(Integer parent_task_id) {
		this.parent_task_id = parent_task_id;
	}

	public String getParent_task_name() {
		return parent_task_name;
	}

	public void setParent_task_name(String parent_task_name) {
		this.parent_task_name = parent_task_name;
	}

	public List<PmoTask> getPmoTask() {
		return pmoTask;
	}

	public void setPmoTask(List<PmoTask> pmoTask) {
		this.pmoTask = pmoTask;
	}
	
}
