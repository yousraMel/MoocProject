package com.inti.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;


import com.inti.formation.entities.Course;

public interface ICourseRepository extends JpaRepository<Course, Long> {
	
	
	

}
