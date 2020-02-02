package br.com.task.taskExercise.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.task.taskExercise.model.Task;
import br.com.task.taskExercise.repository.TaskRepository;

/**
 * 
 * @author luizg
 * Classe que disponibiliza os metodos POST, GET e DELETE para ser usado por um client(testei usando a ferramente POSTMAN)
 *
 */
@RestController
@RequestMapping("/tasks")
public class TasksResource {

	
	@Autowired
	private TaskRepository repository;

	@PostMapping
	public Task adicionar(@Valid @RequestBody Task task) {
		return repository.save(task);
	}

	@GetMapping
	public List<Task> listar(){
		return repository.findAll();

	}

	@DeleteMapping("/{id}")
	public ResponseEntity<Void> remover(@PathVariable Long id){
		Optional<Task> task = repository.findById(id);

		if (task.get() == null) {
			return ResponseEntity.notFound().build();
		}

		repository.delete(task.get());

		return ResponseEntity.noContent().build();
	}


}
