package br.com.desafioAccenture.controller;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.desafioAccenture.model.Task;
import br.com.desafioAccenture.service.TaskService;

@RestController
public class TaskController {

	@Autowired
	TaskService taskService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> saveTask(@RequestBody Task task) {
		task.setId(1);
		Task taskSaved = taskService.save(task);
		
		return new ResponseEntity<Task>(taskSaved, HttpStatus.CREATED);
	}
	
	@RequestMapping(method =  RequestMethod.GET, value = "/task", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<Task>> findAllTasks() {
		Collection<Task> taskFinded = taskService.findAll();
		
		return new ResponseEntity<Collection<Task>>(taskFinded, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/task/{id}")
	public ResponseEntity<Task> deleteTask(@PathVariable Integer id) {	
		
		taskService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/task", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Task> updateTask(@RequestBody Task task){
		Task taskUpdated = taskService.save(task);
		
		return new ResponseEntity<Task>(taskUpdated, HttpStatus.OK);
	}
}
