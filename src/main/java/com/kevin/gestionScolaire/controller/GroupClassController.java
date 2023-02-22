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
@RequestMapping("/gestionscolaire/institution/{id_institution}/groupclass")
public class GroupClassController {

	@Autowired
	GroupClassDao dao;

	@GetMapping({ "", "/" })
	public ResponseEntity<List<GroupClass>> findAllByInstitutionId(@RequestParam(defaultValue = "0") int init,
			@PathVariable long id_institution) {
		if (init == 1) {
		}
		return new ResponseEntity<List<GroupClass>>(dao.findAllByInstitutionId(id_institution), HttpStatus.OK);
	}

	
	@GetMapping("/{id}")
	public ResponseEntity<GroupClass> findOne(@PathVariable long id) {
		Optional<GroupClass> optGroupClass = dao.findById(id);

		return optGroupClass.isPresent() ? new ResponseEntity<GroupClass>(optGroupClass.get(), HttpStatus.OK)
				: new ResponseEntity<GroupClass>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable long id){
		this.dao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@PostMapping({ "", "/" })
	public ResponseEntity<GroupClass> addOne(@RequestBody GroupClass groupclass) {
		this.dao.save(groupclass);
		return new ResponseEntity<GroupClass>(groupclass,HttpStatus.CREATED);
	}
}
