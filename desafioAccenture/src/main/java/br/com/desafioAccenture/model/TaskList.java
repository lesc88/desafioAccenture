package br.com.desafioAccenture.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class TaskList {
	
	@Id
	@GeneratedValue(strategy= GenerationType.AUTO) 
	@Column(nullable = false, updatable = false)
	private Integer id;
	
	private String name;
	
	@OneToMany(targetEntity=Task.class, mappedBy="taskList")	
	private List<Task> taskCollection = new ArrayList<Task>();
	
	public TaskList() {		
	}
	
	public TaskList(Integer id) {
		super();
		this.id = id;			
	}
	
	public TaskList(Integer id, String name) {
		super();
		this.id = id;
		this.name = name;		
	}
		
	public TaskList(Integer id, String name, List<Task> taskCollection) {
		super();
		this.id = id;
		this.name = name;
		this.taskCollection = taskCollection;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Task> getTaskCollection() {
		return taskCollection;
	}
	public void setTaskCollection(List<Task> taskCollection) {
		this.taskCollection = taskCollection;
	}
	
}
