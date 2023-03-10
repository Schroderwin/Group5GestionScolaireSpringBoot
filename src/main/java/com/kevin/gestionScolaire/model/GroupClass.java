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
public class GroupClass {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private String name;
	@JsonIgnoreProperties({"institution","subjects","groupClass","events"})
	@OneToOne(fetch = FetchType.EAGER)
	private Teacher teacher;
	@JsonIgnoreProperties({"groupClasses","teachers","classrooms","subjects"})
	@ManyToOne
	private Institution institution;
	
	@JsonIgnoreProperties({"teacher","subject","groupClass","classroom"})
	@OneToMany( mappedBy = "groupClass")
	private List<ScheduleEvent> events;

}
