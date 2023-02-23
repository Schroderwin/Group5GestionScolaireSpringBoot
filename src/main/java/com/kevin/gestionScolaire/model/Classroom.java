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
public class Classroom {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String name;
	
	private int capacity;
	
	
	@ManyToMany(cascade = CascadeType.ALL)
	private List<Subject> excludedSubjects;
	
	@OneToMany(mappedBy = "classroom",cascade = CascadeType.ALL, fetch = FetchType.EAGER)
	private List<Subject> subjects;
	
	@ManyToOne(fetch = FetchType.EAGER)
	private Institution institution;

	public Classroom(String name, int capacity, List<Subject> excludedSubjects, List<Subject> subjects,
			Institution institution) {
		super();
		this.name = name;
		this.capacity = capacity;
		this.excludedSubjects = excludedSubjects;
		this.subjects = subjects;
		this.institution = institution;
	}

	public Classroom(String name, int capacity) {
		super();
		this.name = name;
		this.capacity = capacity;
	}

	
	
	

}
