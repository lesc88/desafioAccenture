package br.com.desafioAccenture.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.desafioAccenture.model.TaskList;

@Repository
public interface TaskListRepository extends JpaRepository<TaskList, Integer>{	

}
