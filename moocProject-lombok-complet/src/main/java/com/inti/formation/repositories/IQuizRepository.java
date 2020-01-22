package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.inti.formation.entities.Quiz;

public interface IQuizRepository extends JpaRepository<Quiz, Long>{

}
