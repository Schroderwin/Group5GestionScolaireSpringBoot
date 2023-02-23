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
import jakarta.persistence.OneToOne;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String firstName;
	
	private String lastName;
	
	private String birthDate;
	

	@JsonIgnoreProperties({"institution","teachers","classroom","excludedClassrooms"})
	@ManyToMany
	private List<Subject> subjects;
	
	@OneToOne(mappedBy = "teacher")
	private GroupClass groupClass;
	
	@JsonIgnoreProperties({"groupClasses","teachers","classrooms","excludedClassrooms"})
	@ManyToOne
	private Institution institution;
	
	public Teacher(String firstName, String lastName, String birthDate, List<Subject> subjects, GroupClass groupClass,
			Institution institution) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.subjects = subjects;
		this.groupClass = groupClass;
		this.institution = institution;
	}
	
	public Teacher(String firstName, String lastName, String birthDate, List<Subject> subjects) {
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.birthDate = birthDate;
		this.subjects = subjects;
	}

}
