package com.inti.formation.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import com.inti.formation.entities.Question;

public interface IQuestionRepository extends JpaRepository<Question, Long> {

}
