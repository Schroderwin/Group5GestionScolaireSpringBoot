package com.kevin.gestionScolaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionScolaire.model.*;


public interface ScheduleEventDao extends JpaRepository<ScheduleEvent, Long> {
	
	public List<ScheduleEvent> findAllByGroupClassId(long id);

}
