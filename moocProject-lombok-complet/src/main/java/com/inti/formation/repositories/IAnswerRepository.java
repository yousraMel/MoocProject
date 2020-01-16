package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Choice;

public interface IAnswerRepository extends JpaRepository<Choice, Long>{

}
