package com.kevin.gestionScolaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionScolaire.model.*;


public interface EventDao extends JpaRepository<Event, Long> {
	
	public List<Event> findAllByGroupClassId(long id);

}
