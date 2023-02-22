package com.kevin.gestionScolaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionScolaire.model.*;


public interface TeacherDao extends JpaRepository<Teacher, Long> {
	
	public List<Teacher> findAllByInstitutionId(long id);

}
