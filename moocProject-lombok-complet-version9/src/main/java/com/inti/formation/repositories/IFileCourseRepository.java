package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.CourseFile;





public interface IFileCourseRepository extends JpaRepository<CourseFile,Long> {
}
