package com.kevin.gestionScolaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionScolaire.model.*;


public interface ClassroomDao extends JpaRepository<Classroom, Long> {
	
	public List<Classroom> findAllByInstitutionId(long id);

}
