package com.kevin.gestionScolaire.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.kevin.gestionScolaire.model.*;


public interface InstitutionDao extends JpaRepository<Institution, Long> {

}
