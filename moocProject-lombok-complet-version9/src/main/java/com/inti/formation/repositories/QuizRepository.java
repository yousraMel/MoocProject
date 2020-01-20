package com.inti.formation.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.Quiz;


//import jorge.rv.quizzz.model.User;

@Repository("QuizRepository")
public interface QuizRepository extends JpaRepository<Quiz, Long> {

	List<Quiz> findByIsPublishedTrue();

//	Page<Quiz> findByCreatedBy(User user, Pageable pageable);

	@Query("select q from Quiz q where q.name like %?1%")
	List<Quiz> searchByName(String name);
}
