package com.codelifee.exercisecoach.exercisecoach.resource;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.codelifee.exercisecoach.exercisecoach.mapper.ExercisesMapper;
import com.codelifee.exercisecoach.exercisecoach.model.Exercises;

@RestController
@RequestMapping("/rest/exercises")
@CrossOrigin(origins="http://localhost:5000")
public class ExercisesResource {

	private ExercisesMapper exercisesMapper;
			
	@Autowired
	public ExercisesResource(ExercisesMapper exercisesMapper) {
		this.exercisesMapper = exercisesMapper;
	}

	@GetMapping("/all")
	public List<Exercises> getAll() {
		return exercisesMapper.findAll();
	}
	
	@GetMapping("/{exer_id}")
	public Exercises getExercises(@PathVariable("exer_id")String exer_id) {
		return exercisesMapper.getExercises(exer_id);
	}
	
	@PutMapping("/create_exercise")
	public void createExercises(@RequestParam("exer_id")String exer_id, @RequestParam("exer_name")String exer_name, 
			@RequestParam("descriptions")String descriptions) {
		exercisesMapper.insertExercises(exer_id, exer_name, descriptions);
	}
	
	@PostMapping("/{exer_id}")
	public void updateExercises(@PathVariable("exer_id")String exer_id, 
			@RequestParam("exer_name")String exer_name, @RequestParam("descriptions")String descriptions) {
		exercisesMapper.updateExercises(exer_id, exer_name, descriptions);
	}
	
	@DeleteMapping("/{exer_id}")
	public void deleteExercises(@PathVariable("exer_id")String exer_id) {
		exercisesMapper.deleteExercises(exer_id);
	}
}
