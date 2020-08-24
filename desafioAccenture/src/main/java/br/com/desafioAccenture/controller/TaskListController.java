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

import br.com.desafioAccenture.model.TaskList;
import br.com.desafioAccenture.service.TaskListService;

@RestController
public class TaskListController {
	
	@Autowired
	TaskListService taskListService;
	
	@RequestMapping(method = RequestMethod.POST, value = "/taskList", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskList> saveTaskList(@RequestBody TaskList taskList) {
		TaskList taskListSaved = taskListService.save(taskList);
		
		return new ResponseEntity<TaskList>(taskListSaved, HttpStatus.CREATED);
	}
	
	@RequestMapping(method =  RequestMethod.GET, value = "/taskList", produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Collection<TaskList>> findAllTaskList() {
		Collection<TaskList> taskListFinded = taskListService.findAll();
		
		return new ResponseEntity<Collection<TaskList>>(taskListFinded, HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.DELETE, value = "/taskList/{id}")
	public ResponseEntity<TaskList> deleteTaskList(@PathVariable Integer id) {	
		
		taskListService.delete(id);
		
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@RequestMapping(method = RequestMethod.PUT, value = "/taskList", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<TaskList> updateTaskList(@RequestBody TaskList taskList){
		TaskList taskListUpdated = taskListService.save(taskList);
		
		return new ResponseEntity<TaskList>(taskListUpdated, HttpStatus.OK);
	}
}
