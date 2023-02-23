package com.kevin.gestionScolaire.model;

import java.util.ArrayList;
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
	
	@JsonIgnoreProperties({"institution","subjects"})
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private List<Teacher> teachers = new ArrayList<>();
	
	@JsonIgnoreProperties({"institution","teacher"})
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private List<GroupClass> groupClasses = new ArrayList<>();
	
	@JsonIgnoreProperties({"institution","subjects","excludedSubjects"})
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private List<Classroom> classrooms = new ArrayList<>();
	
	@JsonIgnoreProperties({"institution","teachers","classroom","excludedClassrooms"})
	@OneToMany(mappedBy = "institution", cascade = CascadeType.ALL)
	private List<Subject> subjects = new ArrayList<>();
}
