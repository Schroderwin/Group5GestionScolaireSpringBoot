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
	@JsonIgnoreProperties({"institution","teachers","classroom","excludedClassrooms","events"})
	@ManyToMany(fetch = FetchType.EAGER)
	private List<Subject> excludedSubjects;
	
	@JsonIgnoreProperties({"teacher","subject","groupClass","classroom"})
	@OneToMany(mappedBy = "classroom",fetch = FetchType.EAGER)
	private List<ScheduleEvent> events;
	
	@JsonIgnoreProperties({"groupClasses","teachers","classrooms","excludedClassrooms"})
	@ManyToOne(fetch = FetchType.EAGER)
	private Institution institution;
}
