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
public class EventController {

	@Autowired
	EventDao dao;

	@GetMapping({ "/groupclass/{id_groupclass}/event", "/groupclass/{id_groupclass}/event" })
	public ResponseEntity<List<Event>> findAllByGroupClassId(@RequestParam(defaultValue = "0") int init,
			@PathVariable long id_groupclass) {
		if (init == 1) {
		}
		return new ResponseEntity<List<Event>>(dao.findAllByGroupClassId(id_groupclass), HttpStatus.OK);
	}

	
	@GetMapping("/event/{id}")
	public ResponseEntity<Event> findOne(@PathVariable long id) {
		Optional<Event> optEvent = dao.findById(id);

		return optEvent.isPresent() ? new ResponseEntity<Event>(optEvent.get(), HttpStatus.OK)
				: new ResponseEntity<Event>(HttpStatus.NOT_FOUND);
	}
	
	@DeleteMapping("/event/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable long id){
		this.dao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	
	@PostMapping({ "/event", "/event/" })
	public ResponseEntity<Event> addOne(@RequestBody Event event) {
		this.dao.save(event);
		return new ResponseEntity<Event>(event,HttpStatus.CREATED);
	}
}
