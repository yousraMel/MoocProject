package com.inti.formation.iservices;

import java.util.List;

import com.inti.formation.entities.Question;

public interface IQuestionService {
	
	public Question saveOrUpdateQuestion(Question question);
	public void deleteQuestion (Long idQuestion);
	public Question getByIdQuestion(Long idQuestion);
	public List<Question> getAllQuestions();

}
