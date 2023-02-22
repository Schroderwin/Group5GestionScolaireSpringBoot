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
	
	@JsonIgnoreProperties
	@OneToOne(cascade = CascadeType.REMOVE)
	private Teacher teacher;
	
	@JsonIgnoreProperties
	@ManyToOne(fetch = FetchType.EAGER)
	private Institution institution;

	public GroupClass(String name, Teacher teacher, Institution institution) {
		super();
		this.name = name;
		this.teacher = teacher;
		this.institution = institution;
	}

	public GroupClass(String name, Teacher teacher) {
		super();
		this.name = name;
		this.teacher = teacher;
	}
	
	

}
