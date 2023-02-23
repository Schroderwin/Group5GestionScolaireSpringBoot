package com.kevin.gestionScolaire.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.gestionScolaire.dao.*;
import com.kevin.gestionScolaire.model.*;

@CrossOrigin
@RestController
@RequestMapping("/gestionscolaire")
public class TeacherController {

	@Autowired
	TeacherDao dao;

	@GetMapping({ "/institution/{id_institution}/teacher", "/institution/{id_institution}/teacher/" })
	public ResponseEntity<List<Teacher>> findAllByInstitutionId(@RequestParam(defaultValue = "0") int init,
			@PathVariable long id_institution) {
		if (init == 1) {
		}
		return new ResponseEntity<List<Teacher>>(dao.findAllByInstitutionId(id_institution), HttpStatus.OK);
	}

	
	@GetMapping("/teacher/{id}")
	public ResponseEntity<Teacher> findOne(@PathVariable long id) {
		Optional<Teacher> optTeacher = dao.findById(id);

		return optTeacher.isPresent() ? new ResponseEntity<Teacher>(optTeacher.get(), HttpStatus.OK)
				: new ResponseEntity<Teacher>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/teacher/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable long id){
		this.dao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@PostMapping({ "/teacher", "/teacher/" })
	public ResponseEntity<Teacher> addOne(@RequestBody Teacher teacher) {
		this.dao.save(teacher);
		return new ResponseEntity<Teacher>(teacher,HttpStatus.CREATED);
	}
}
