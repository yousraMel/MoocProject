package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Quiz;

public interface IQuizService {
	public Quiz saveOrUpdateQuiz(Quiz u);
	public void deleteByIdQuiz(Long id);
	public Quiz getByIdQuiz(Long id);
	public List<Quiz> getAllQuiz();
}
