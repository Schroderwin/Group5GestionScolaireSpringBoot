package com.kevin.gestionScolaire.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@RequiredArgsConstructor
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String color;
	
	@JsonIgnoreProperties
	@ManyToMany
	private List<Teacher> teachers;
	
	@JsonIgnoreProperties
	@ManyToMany
	private List<Classroom> excludedClassrooms;
	
	@JsonIgnoreProperties
	@ManyToOne
	private Classroom classroom;
	
	@JsonIgnoreProperties
	@ManyToOne
	private Institution institution;

}
