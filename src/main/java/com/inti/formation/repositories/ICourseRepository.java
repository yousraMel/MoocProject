package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entites.Course;

public interface ICourseRepository extends JpaRepository <Course, Long> {

}
