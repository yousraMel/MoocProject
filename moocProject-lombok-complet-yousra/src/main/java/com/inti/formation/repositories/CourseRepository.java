package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Course;

public interface CourseRepository extends JpaRepository<Course, Long> {

}
