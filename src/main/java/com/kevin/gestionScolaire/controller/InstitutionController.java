package com.kevin.gestionScolaire.controller;

import java.util.ArrayList;
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
public class InstitutionController {

	@Autowired
	InstitutionDao dao;

	@GetMapping({"/home","", "/" })
	public ResponseEntity<List<Institution>> findAll(@RequestParam(defaultValue = "0") int init) {
		if (init == 1) {
			Subject subject = new Subject("Mathématique","bg-primary");
			Classroom classroom = new Classroom("A1",40);
			List<Subject> subjects = new ArrayList<Subject>();
			subjects.add(subject);
			Teacher teacher = new Teacher("Bobby","Bob","01-06-1997",subjects);
			GroupClass groupClass = new GroupClass("3E",teacher);
			List<Teacher> teachers = new ArrayList<Teacher>();
			teachers.add(teacher);
			List<GroupClass> groupClasses = new ArrayList<GroupClass>();
			groupClasses.add(groupClass);
			List<Classroom> classrooms = new ArrayList<Classroom>();
			classrooms.add(classroom);
			this.dao.save(new Institution("College 1", "rue du pif", Type.COLLEGE,teachers,groupClasses,classrooms,subjects));
		}
		return new ResponseEntity<List<Institution>>(dao.findAll(), HttpStatus.OK);
	}

	
	@GetMapping("/institution/{id}")
	public ResponseEntity<Institution> findOne(@PathVariable long id) {
		Optional<Institution> optInstitution = dao.findById(id);

		return optInstitution.isPresent() ? new ResponseEntity<Institution>(optInstitution.get(), HttpStatus.OK)
				: new ResponseEntity<Institution>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/institution/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable long id){
		this.dao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@PostMapping({ "/institution" })
	public ResponseEntity<Institution> addOne(@RequestBody Institution institution) {
		this.dao.save(institution);
		return new ResponseEntity<Institution>(institution,HttpStatus.CREATED);
	}
}
