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

	public Institution(String name, String adresse, Type type, List<Teacher> teachers,
			List<GroupClass> groupClasses, List<Classroom> classrooms, List<Subject> subjects) {
		this.name=name;
		this.adresse=adresse;
		this.type=type;
		this.teachers=teachers;
		this.groupClasses=groupClasses;
		this.classrooms=classrooms;
		this.subjects=subjects;
		// TODO Auto-generated constructor stub
	}

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
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private List<Teacher> teachers;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private List<GroupClass> groupClasses;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private List<Classroom> classrooms;
	
	@JsonIgnoreProperties
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private List<Subject> subjects;
	
	
	
}
