package com.kevin.gestionScolaire.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
public class Institution {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NonNull
	private String name;
	
	@NonNull
	private String adresse;
	
	@NonNull
	private Type type;
	
	private String phone;
	
	private String logo;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Teacher> teachers;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<GroupClass> groupClasses;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Classroom> classrooms;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "institution", cascade = CascadeType.REMOVE)
	private List<Subject> subjects;
	
	
	
}
