package br.com.task.taskExercise.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.task.taskExercise.model.Task;

public interface TaskRepository extends JpaRepository<Task, Long> {
	
	 

}
