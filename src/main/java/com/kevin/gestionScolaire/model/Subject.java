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
	@JsonIgnoreProperties({"institution","subjects","classroom","groupClass","events"})
	@ManyToMany(mappedBy = "subjects", fetch = FetchType.EAGER)
	private List<Teacher> teachers;
	@JsonIgnoreProperties({"institution","excludedSubjects","events"})
	@ManyToMany(mappedBy = "excludedSubjects", fetch = FetchType.EAGER)
	private List<Classroom> excludedClassrooms;
	@JsonIgnoreProperties({"teacher","subject","groupClass","events"})
	@OneToMany(mappedBy = "subject",fetch = FetchType.EAGER)
	private List<ScheduleEvent> events;
	@JsonIgnoreProperties({"groupClasses","teachers","classrooms","subjects"})
	@ManyToOne(fetch = FetchType.EAGER)
	private Institution institution;
}
