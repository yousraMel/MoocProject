package com.inti.formation.iservices;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.inti.formation.entities.Quiz;
import com.inti.formation.support.Response;
import com.inti.formation.support.Result;


public interface IQuizService {
	Quiz save(Quiz quiz);

//	Page<Quiz> findAll(Pageable pageable);
	List<Quiz> findAll();

//	Page<Quiz> findAllPublished(Pageable pageable);
	List<Quiz> findAllPublished();

//	Page<Quiz> findQuizzesByUser(Pageable pageable);

	Quiz find(Long id) ;

	Quiz update(Quiz quiz) ;

	void delete(Quiz quiz) ;

//	Page<Quiz> search(String query, Pageable pageable);
	List<Quiz> search(String query);

	Result checkAnswers(Quiz quiz, List<Response> answersBundle);

	void publishQuiz(Quiz quiz);
}
