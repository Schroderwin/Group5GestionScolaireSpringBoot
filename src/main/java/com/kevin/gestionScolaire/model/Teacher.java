package com.kevin.gestionScolaire.model;

import java.time.LocalDate;
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
	
	private LocalDate birthDate;
	

	@JsonIgnoreProperties({"institution","teachers","classroom","excludedClassrooms"})
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Subject> subjects;
	
	@JsonIgnoreProperties({"teacher","institution"})
	@OneToOne(mappedBy = "teacher",fetch = FetchType.EAGER)
	private GroupClass groupClass;
	
	@JsonIgnoreProperties({"groupClasses","teachers","classrooms","excludedClassrooms"})
	@ManyToOne
	private Institution institution;
}
