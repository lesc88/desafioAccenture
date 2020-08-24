package br.com.desafioAccenture.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Task {

	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
	@Column(nullable = false, updatable = false)
	private Integer id;

	@ManyToOne
	@JoinColumn(name = "idTasklist")
	private TaskList taskList;

	private String description;
	
	public Task() {				
	}
	
	public Task(Integer id) {
		super();
		this.id = id;			
	}
	
	public Task(Integer id, TaskList taskList) {
		super();
		this.id = id;
		this.taskList = taskList;		
	}
	
	public Task(Integer id, TaskList taskList, String description) {
		super();
		this.id = id;
		this.taskList = taskList;
		this.description = description;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public TaskList getTaskList() {
		return taskList;
	}

	public void setTaskList(TaskList taskList) {
		this.taskList = taskList;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
