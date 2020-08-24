package br.com.desafioAccenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioAccenture.model.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer>{

}
