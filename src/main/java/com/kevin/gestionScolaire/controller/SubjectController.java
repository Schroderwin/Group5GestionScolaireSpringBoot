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
public class SubjectController {

	@Autowired
	SubjectDao dao;

	@GetMapping({ "/institution/{id_institution}/subject", "/institution/{id_institution}/subject/" })
	public ResponseEntity<List<Subject>> findAllByInstitutionId(@RequestParam(defaultValue = "0") int init,
			@PathVariable long id_institution) {
		if (init == 1) {
		}
		return new ResponseEntity<List<Subject>>(dao.findAllByInstitutionId(id_institution), HttpStatus.OK);
	}

	
	@GetMapping("/subject/{id}")
	public ResponseEntity<Subject> findOne(@PathVariable long id) {
		Optional<Subject> optSubject = dao.findById(id);

		return optSubject.isPresent() ? new ResponseEntity<Subject>(optSubject.get(), HttpStatus.OK)
				: new ResponseEntity<Subject>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/subject/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable long id){
		this.dao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@PostMapping({ "/subject", "/subject/" })
	public ResponseEntity<Subject> addOne(@RequestBody Subject subject) {
		this.dao.save(subject);
		return new ResponseEntity<Subject>(subject,HttpStatus.CREATED);
	}
}
