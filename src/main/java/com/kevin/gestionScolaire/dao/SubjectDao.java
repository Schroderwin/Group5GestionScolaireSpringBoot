package com.kevin.gestionScolaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionScolaire.model.*;


public interface SubjectDao extends JpaRepository<Subject, Long> {
	
	public List<Subject> findAllByInstitutionId(long id);

}
