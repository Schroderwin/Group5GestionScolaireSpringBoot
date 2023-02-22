package com.kevin.gestionScolaire.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionScolaire.model.*;


public interface GroupClassDao extends JpaRepository<GroupClass, Long> {
	
	public List<GroupClass> findAllByInstitutionId(long id);

}
