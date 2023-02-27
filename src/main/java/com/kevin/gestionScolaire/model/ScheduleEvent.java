package com.kevin.gestionScolaire.model;

import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
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
public class ScheduleEvent {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	private LocalDate date;
	private LocalTime beginTime;
	private LocalTime endTime;
	
	@JsonIgnoreProperties({"subjects","groupClass","institution"})
	@ManyToOne(fetch = FetchType.EAGER)
	private Teacher teacher;
	@JsonIgnoreProperties({"teachers","institution","excludedClassrooms"})
	@ManyToOne(fetch = FetchType.EAGER)
	private Subject subject;
	
	@JsonIgnoreProperties({"excludedSubjects","events","institution"})
	@ManyToOne(fetch = FetchType.EAGER)
	private Classroom classroom;
	
	@JsonIgnoreProperties({"events","institution","teacher"})
	@ManyToOne(fetch = FetchType.EAGER)
	private GroupClass groupClass;
}
