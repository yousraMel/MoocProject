package com.inti.formation.repositories;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.inti.formation.entities.Quiz;


//import jorge.rv.quizzz.model.User;

@Repository("QuizRepository2")
public interface QuizRepository2 extends PagingAndSortingRepository<Quiz, Long> {

	Page<Quiz> findByIsPublishedTrue(Pageable pageable);

//	Page<Quiz> findByCreatedBy(User user, Pageable pageable);

	@Query("select q from Quiz q where q.name like %?1%")
	Page<Quiz> searchByName(String name, Pageable pageable);
}
