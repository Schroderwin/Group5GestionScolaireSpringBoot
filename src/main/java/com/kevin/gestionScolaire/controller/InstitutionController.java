package com.kevin.gestionScolaire.controller;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.kevin.gestionScolaire.dao.*;
import com.kevin.gestionScolaire.model.*;

@CrossOrigin
@RestController
@RequestMapping("/gestionscolaire")
public class InstitutionController {

	@Autowired
	InstitutionDao institutionDao;

	@Autowired
	ClassroomDao classdao;

	@Autowired
	GroupClassDao groupdao;

	@Autowired
	SubjectDao subjectdao;

	@Autowired
	TeacherDao teacherdao;

	@GetMapping({ "/home", "", "/" })
	public ResponseEntity<List<Institution>> findAll(@RequestParam(defaultValue = "0") int init) {
		if (init == 1) {

			Institution institution = new Institution();
			institution.setName("Collège Chambéry");
			institution.setAdresse("Villenave d'Ornon");
			institution.setPhone("0556454512");
			institution.setType(Type.COLLEGE);

			Subject subject1 = new Subject();
			subject1.setName("EPS");
			subject1.setColor("Green");
			subject1.setInstitution(institution);

			Subject subject2 = new Subject();
			subject2.setName("Espagnol");
			subject2.setColor("Yellow");
			subject2.setInstitution(institution);

			Subject subject3 = new Subject();
			subject3.setName("Physique-Chimie");
			subject3.setColor("Blue");
			subject3.setInstitution(institution);

			Subject subject4 = new Subject();
			subject4.setName("SVT");
			subject4.setColor("Orange");
			subject4.setInstitution(institution);

			Classroom classroom1 = new Classroom();
			classroom1.setCapacity(30);
			classroom1.setExcludedSubjects(List.of(subject2, subject4));
			classroom1.setName("B103");
			classroom1.setInstitution(institution);

			Classroom classroom2 = new Classroom();
			classroom2.setCapacity(30);
			classroom2.setExcludedSubjects(List.of(subject1));
			classroom2.setName("B104");
			classroom2.setInstitution(institution);

			Teacher teacher1 = new Teacher();
			teacher1.setBirthDate(LocalDate.of(1957, 06, 23));
			teacher1.setFirstName("Alain");
			teacher1.setLastName("Martin");
			teacher1.setInstitution(institution);
			teacher1.setSubjects(List.of(subject1, subject2));

			Teacher teacher2 = new Teacher();
			teacher2.setBirthDate(LocalDate.of(1971, 02, 13));
			teacher2.setFirstName("Michel");
			teacher2.setLastName("Dupont");
			teacher2.setInstitution(institution);
			teacher2.setSubjects(List.of(subject3, subject4));

			GroupClass groupClass1 = new GroupClass();
			groupClass1.setName("3ème 2");
			groupClass1.setTeacher(teacher1);
			groupClass1.setInstitution(institution);

			GroupClass groupClass2 = new GroupClass();
			groupClass2.setName("3ème 1");
			groupClass2.setTeacher(teacher2);
			groupClass2.setInstitution(institution);

			institution.setSubjects(List.of(subject1, subject2, subject3, subject4));
			institution.setTeachers(List.of(teacher1, teacher2));
			institution.setClassrooms(List.of(classroom1, classroom2));
			institution.setGroupClasses(List.of(groupClass1, groupClass2));

			this.institutionDao.save(institution);

			Institution institution2 = new Institution();
			institution2.setName("Lycée Victor Louis");
			institution2.setAdresse("Talence");
			institution2.setPhone("0556451241");
			institution2.setType(Type.LYCEE);

			Subject subject12 = new Subject();
			subject12.setName("Histoire");
			subject12.setColor("Brown");
			subject12.setInstitution(institution2);

			Subject subject22 = new Subject();
			subject22.setName("Français");
			subject22.setColor("Yellow");
			subject22.setInstitution(institution2);

			Subject subject32 = new Subject();
			subject32.setName("Anglais");
			subject32.setColor("Blue");
			subject32.setInstitution(institution2);

			Subject subject42 = new Subject();
			subject42.setName("Mathématiques");
			subject42.setColor("Orange");
			subject42.setInstitution(institution2);

			Classroom classroom12 = new Classroom();
			classroom12.setCapacity(30);
			classroom12.setExcludedSubjects(List.of(subject22, subject42));
			classroom12.setName("A305");
			classroom12.setInstitution(institution2);

			Teacher teacher12 = new Teacher();
			teacher12.setBirthDate(LocalDate.of(1957, 06, 23));
			teacher12.setFirstName("Alain");
			teacher12.setLastName("Giresse");
			teacher12.setInstitution(institution2);
			teacher12.setSubjects(List.of(subject32, subject42));

			GroupClass groupClass12 = new GroupClass();
			groupClass12.setName("2nd2");
			groupClass12.setTeacher(teacher12);
			groupClass12.setInstitution(institution2);

			institution2.setSubjects(List.of(subject12, subject22, subject32, subject42));
			institution2.setTeachers(List.of(teacher12));
			institution2.setClassrooms(List.of(classroom12));
			institution2.setGroupClasses(List.of(groupClass12));

			this.institutionDao.save(institution2);

		}
		return new ResponseEntity<List<Institution>>(institutionDao.findAll(), HttpStatus.OK);
	}

	@GetMapping("/institution/{id}")
	public ResponseEntity<Institution> findOne(@PathVariable long id) {
		Optional<Institution> optInstitution = institutionDao.findById(id);

		return optInstitution.isPresent() ? new ResponseEntity<Institution>(optInstitution.get(), HttpStatus.OK)
				: new ResponseEntity<Institution>(HttpStatus.NOT_FOUND);
	}

	@DeleteMapping("/institution/{id}")
	public ResponseEntity<Void> deleteOne(@PathVariable long id) {
		this.institutionDao.deleteById(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

	@PostMapping({ "/institution" })
	public ResponseEntity<Institution> addOne(@RequestBody Institution institution) {
		this.institutionDao.save(institution);
		return new ResponseEntity<Institution>(institution, HttpStatus.CREATED);
	}
}
