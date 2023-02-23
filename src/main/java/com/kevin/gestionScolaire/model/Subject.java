package com.kevin.gestionScolaire.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
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
public class Subject {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private String color;
	
	
	
	public Subject(String name, String color, List<Teacher> teachers, List<Classroom> excludedClassrooms,
			Classroom classroom, Institution institution) {
		super();
		this.name = name;
		this.color = color;
		this.teachers = teachers;
		this.excludedClassrooms = excludedClassrooms;
		this.classroom = classroom;
		this.institution = institution;
	}
	
	public Subject(String name, String color) {
		super();
		this.name = name;
		this.color = color;
	}

	
	@ManyToMany(mappedBy = "subjects", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Teacher> teachers;
	
	@ManyToMany(mappedBy = "excludedSubjects", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Classroom> excludedClassrooms;
	
	@ManyToOne
	private Classroom classroom;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Institution institution;

}
