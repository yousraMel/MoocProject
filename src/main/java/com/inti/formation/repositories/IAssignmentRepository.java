package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Assignment;

public interface IAssignmentRepository extends JpaRepository<Assignment, Long>{

}
