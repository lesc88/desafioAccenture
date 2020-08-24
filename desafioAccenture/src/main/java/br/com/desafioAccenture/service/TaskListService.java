package br.com.desafioAccenture.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioAccenture.model.TaskList;
import br.com.desafioAccenture.repository.TaskListRepository;

@Service
public class TaskListService {
	
	@Autowired
	TaskListRepository taskListRepository;	

	public TaskList save(TaskList taskList) {		
		return taskListRepository.save(taskList);
	}
	
	public Collection<TaskList> findAll(){
		return taskListRepository.findAll();
	}
	
	public Optional<TaskList> findById(Integer id) {
		return taskListRepository.findById(id);
	}
	
	public void delete(Integer id) {
		taskListRepository.deleteById(id);
	}
}
