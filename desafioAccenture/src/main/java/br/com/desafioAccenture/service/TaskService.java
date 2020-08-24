package br.com.desafioAccenture.service;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.desafioAccenture.model.Task;
import br.com.desafioAccenture.repository.TaskRepository;

@Service
public class TaskService {
	
	@Autowired
	TaskRepository taskRepository;	

	public Task save(Task task) {		
		return taskRepository.save(task);
	}
	
	public Collection<Task> findAll(){
		return taskRepository.findAll();
	}
	
	public Optional<Task> findById(Integer id) {
		return taskRepository.findById(id);
	}
	
	public void delete(Integer id) {
		taskRepository.deleteById(id);
	}
}
